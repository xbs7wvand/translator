package sample;

import java.io.IOException;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


public class Controller {
    public TextField textrus;
    public Button btntr;

    public TextField engtext;
    public TextArea oneng;
    public TextArea onrus;
    public ProgressBar pgbar;

    public void tns(MouseEvent mouseEvent) throws IOException{
        int size = 0;
        String word = onrus.getText();
        String link = "https://www.m-translate.ru/alternative?fromText="+word+"&from=ru&to=en";
        Document doc = Jsoup.connect(link).get();
        Elements translate = doc.getElementsByClass("line");
        oneng.setText(translate.html());
        size = oneng.getLength();
        if(size!=0){
            pgbar.setProgress(1);
        }else{pgbar.setProgress(0);}

    }
}

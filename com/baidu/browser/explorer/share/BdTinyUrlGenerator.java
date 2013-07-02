package com.baidu.browser.explorer.share;

import com.baidu.zeus.Headers;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class BdTinyUrlGenerator {
    private static final String APIKEY = "57425770";
    private static final int LENGTH_THRESHOLD = 25;
    private static final String SHORTEN_URL = "http://api.t.sina.com.cn/short_url/shorten.json";
    private BdTinyUrlRecievedListener mListener;
    private String mLongUrl;

    /* loaded from: classes.dex */
    public interface BdTinyUrlRecievedListener {
        void onTinyUrlRecieved(String str);
    }

    public void generate(String str) {
        if (str == null || str.equals("") || str.length() < 25) {
            if (this.mListener != null) {
                this.mListener.onTinyUrlRecieved(str);
                return;
            }
            return;
        }
        this.mLongUrl = str;
        new Thread(new Runnable() { // from class: com.baidu.browser.explorer.share.BdTinyUrlGenerator.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    URLConnection openConnection = new URL("http://api.t.sina.com.cn/short_url/shorten.json?" + ("source=57425770&url_long=" + URLEncoder.encode(BdTinyUrlGenerator.this.mLongUrl))).openConnection();
                    openConnection.setRequestProperty("accept", "*/*");
                    openConnection.setRequestProperty(Headers.CONN_DIRECTIVE, "Keep-Alive");
                    openConnection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
                    openConnection.connect();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(openConnection.getInputStream()));
                    String str2 = "";
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        str2 = String.valueOf(str2) + readLine;
                    }
                    if (str2.startsWith("[") && str2.endsWith("]")) {
                        str2 = str2.substring(1, str2.length() - 1);
                    }
                    JSONObject jSONObject = new JSONObject(str2);
                    if (BdTinyUrlGenerator.this.mListener != null) {
                        BdTinyUrlGenerator.this.mListener.onTinyUrlRecieved(jSONObject.getString("url_short"));
                    }
                } catch (Exception e) {
                    if (BdTinyUrlGenerator.this.mListener != null) {
                        BdTinyUrlGenerator.this.mListener.onTinyUrlRecieved(BdTinyUrlGenerator.this.mLongUrl);
                    }
                }
            }
        }).start();
    }

    public void setEventListener(BdTinyUrlRecievedListener bdTinyUrlRecievedListener) {
        this.mListener = bdTinyUrlRecievedListener;
    }
}

package com.baidu.adp.lib.network.http;

import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class g {
    public Map<String, List<String>> kF;
    public byte[] kG;
    public int kH;
    public int responseCode;
    public volatile boolean kE = false;
    public String contentEncoding = "";
    public String contentType = "";
    public String contentLength = "";

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            this.responseCode = httpURLConnection.getResponseCode();
            this.contentEncoding = httpURLConnection.getContentEncoding();
            this.contentType = httpURLConnection.getContentType();
            this.kF = httpURLConnection.getHeaderFields();
        }
    }

    public boolean dW() {
        return this.responseCode == 200;
    }
}

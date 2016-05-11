package com.baidu.adp.lib.network.http;

import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class h {
    public Map<String, List<String>> lF;
    public byte[] lG;
    public int lH;
    public volatile boolean lD = false;
    public int responseCode = -1;
    public int lE = -1;
    public String contentEncoding = "";
    public String contentType = "";
    public String contentLength = "";

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            this.responseCode = httpURLConnection.getResponseCode();
            this.contentEncoding = httpURLConnection.getContentEncoding();
            this.contentType = httpURLConnection.getContentType();
            this.contentLength = new StringBuilder(String.valueOf(httpURLConnection.getContentLength())).toString();
            this.lF = httpURLConnection.getHeaderFields();
        }
    }

    public boolean dB() {
        return this.responseCode == 200;
    }
}

package com.baidu.adp.lib.network.http;

import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class h {
    public Map<String, List<String>> vN;
    public byte[] vO;
    public int vP;
    public volatile boolean vL = false;
    public int responseCode = -1;
    public int vM = -1;
    public String contentEncoding = "";
    public String contentType = "";
    public String contentLength = "";

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(HttpURLConnection httpURLConnection) throws Exception {
        if (httpURLConnection != null) {
            this.responseCode = httpURLConnection.getResponseCode();
            this.contentEncoding = httpURLConnection.getContentEncoding();
            this.contentType = httpURLConnection.getContentType();
            this.contentLength = new StringBuilder(String.valueOf(httpURLConnection.getContentLength())).toString();
            this.vN = httpURLConnection.getHeaderFields();
        }
    }

    public boolean fH() {
        return this.responseCode == 200;
    }
}

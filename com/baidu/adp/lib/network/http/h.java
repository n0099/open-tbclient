package com.baidu.adp.lib.network.http;

import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class h {
    public Map<String, List<String>> vR;
    public byte[] vS;
    public int vT;
    public volatile boolean vP = false;
    public int responseCode = -1;
    public int vQ = -1;
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
            this.vR = httpURLConnection.getHeaderFields();
        }
    }

    public boolean fH() {
        return this.responseCode == 200;
    }
}

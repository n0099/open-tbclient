package com.baidu.adp.lib.network.http;

import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class h {
    public Map<String, List<String>> oF;
    public byte[] oG;
    public int oH;
    public volatile boolean oD = false;
    public int responseCode = -1;
    public int oE = -1;
    public String contentEncoding = "";
    public String contentType = "";
    public String contentLength = "";

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(HttpURLConnection httpURLConnection) throws Exception {
        if (httpURLConnection != null) {
            this.responseCode = httpURLConnection.getResponseCode();
            this.contentEncoding = httpURLConnection.getContentEncoding();
            this.contentType = httpURLConnection.getContentType();
            this.contentLength = new StringBuilder(String.valueOf(httpURLConnection.getContentLength())).toString();
            this.oF = httpURLConnection.getHeaderFields();
        }
    }

    public boolean ew() {
        return this.responseCode == 200;
    }
}

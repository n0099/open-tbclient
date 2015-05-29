package com.baidu.adp.lib.network.http;

import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class g {
    public int responseCode;
    public Map<String, List<String>> vj;
    public byte[] vk;
    public int vl;
    public volatile boolean vi = false;
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
            this.vj = httpURLConnection.getHeaderFields();
        }
    }

    public boolean he() {
        return this.responseCode == 200;
    }
}

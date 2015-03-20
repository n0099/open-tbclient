package com.baidu.adp.lib.network.http;

import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class g {
    public int responseCode;
    public Map<String, List<String>> vX;
    public byte[] vY;
    public int vZ;
    public volatile boolean vW = false;
    public String contentEncoding = "";
    public String contentType = "";
    public String contentLength = "";

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            this.responseCode = httpURLConnection.getResponseCode();
            this.contentEncoding = httpURLConnection.getContentEncoding();
            this.contentType = httpURLConnection.getContentType();
            this.vX = httpURLConnection.getHeaderFields();
        }
    }

    public boolean hs() {
        return this.responseCode == 200;
    }
}

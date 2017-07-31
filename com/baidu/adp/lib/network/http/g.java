package com.baidu.adp.lib.network.http;

import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class g {
    public Map<String, List<String>> xu;
    public byte[] xv;
    public int xw;
    public volatile boolean xs = false;
    public int responseCode = -1;
    public int xt = -1;
    public String contentEncoding = "";
    public String contentType = "";
    public String contentLength = "";

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(HttpURLConnection httpURLConnection) throws Exception {
        if (httpURLConnection != null) {
            this.responseCode = httpURLConnection.getResponseCode();
            this.contentEncoding = httpURLConnection.getContentEncoding();
            this.contentType = httpURLConnection.getContentType();
            this.contentLength = httpURLConnection.getContentLength() + "";
            this.xu = httpURLConnection.getHeaderFields();
        }
    }

    public boolean fQ() {
        return this.responseCode == 200;
    }
}

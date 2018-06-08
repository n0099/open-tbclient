package com.baidu.adp.lib.network.http;

import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class g {
    public Map<String, List<String>> Ac;
    public byte[] Ae;
    public int Af;
    public volatile boolean Aa = false;
    public int responseCode = -1;
    public int Ab = -1;
    public String contentEncoding = "";
    public String contentType = "";
    public String contentLength = "";

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(HttpURLConnection httpURLConnection) throws Exception {
        if (httpURLConnection != null) {
            this.responseCode = httpURLConnection.getResponseCode();
            this.contentEncoding = httpURLConnection.getContentEncoding();
            this.contentType = httpURLConnection.getContentType();
            this.contentLength = httpURLConnection.getContentLength() + "";
            this.Ac = httpURLConnection.getHeaderFields();
        }
    }

    public boolean ic() {
        return this.responseCode == 200;
    }
}

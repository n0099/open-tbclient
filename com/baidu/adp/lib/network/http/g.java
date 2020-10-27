package com.baidu.adp.lib.network.http;

import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class g {
    public Map<String, List<String>> Mp;
    public int downSize;
    public byte[] retBytes;
    public volatile boolean Mo = false;
    public int responseCode = -1;
    public int mNetErrorCode = -1;
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
            this.Mp = httpURLConnection.getHeaderFields();
        }
    }

    public boolean mG() {
        return this.responseCode == 200;
    }
}

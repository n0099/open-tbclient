package com.baidu.adp.lib.network.http;

import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public final class g {
    public int b;
    public Map<String, List<String>> f;
    public byte[] g;
    public volatile boolean a = false;
    public String c = "";
    public String d = "";
    public String e = "";

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            this.b = httpURLConnection.getResponseCode();
            this.c = httpURLConnection.getContentEncoding();
            this.d = httpURLConnection.getContentType();
            this.f = httpURLConnection.getHeaderFields();
        }
    }
}

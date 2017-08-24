package com.baidu.tbadk.core.hybrid;

import android.text.TextUtils;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class v {
    private Map<String, String> ael = new HashMap();
    private Map<String, List<String>> kv;
    private int responseCode;
    private String url;

    public void setUrl(String str) {
        this.url = str;
    }

    public int getResponseCode() {
        return this.responseCode;
    }

    public Map<String, List<String>> uf() {
        return this.kv;
    }

    public void addHeader(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.ael.put(str, str2);
        }
    }

    public byte[] ug() {
        int retryCount = com.baidu.adp.framework.c.b.dC().getRetryCount();
        for (int i = 0; i < retryCount; i++) {
            try {
                return uh();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private byte[] uh() throws Exception {
        if (TextUtils.isEmpty(this.url)) {
            return null;
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.url).openConnection();
        httpURLConnection.setDoInput(true);
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setConnectTimeout(com.baidu.adp.framework.c.b.dC().dD().dG());
        httpURLConnection.setReadTimeout(com.baidu.adp.framework.c.b.dC().dF().dG());
        for (Map.Entry<String, String> entry : this.ael.entrySet()) {
            httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
        }
        httpURLConnection.connect();
        this.responseCode = httpURLConnection.getResponseCode();
        this.kv = httpURLConnection.getHeaderFields();
        return o.o(httpURLConnection.getInputStream());
    }
}

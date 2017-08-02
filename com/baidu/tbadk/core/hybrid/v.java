package com.baidu.tbadk.core.hybrid;

import android.text.TextUtils;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class v {
    private Map<String, String> acM = new HashMap();
    private Map<String, List<String>> acN;
    private int responseCode;
    private String url;

    public void setUrl(String str) {
        this.url = str;
    }

    public int getResponseCode() {
        return this.responseCode;
    }

    public Map<String, List<String>> tU() {
        return this.acN;
    }

    public void addHeader(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.acM.put(str, str2);
        }
    }

    public byte[] tV() {
        int retryCount = com.baidu.adp.framework.c.b.dr().getRetryCount();
        for (int i = 0; i < retryCount; i++) {
            try {
                return tW();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private byte[] tW() throws Exception {
        if (TextUtils.isEmpty(this.url)) {
            return null;
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.url).openConnection();
        httpURLConnection.setDoInput(true);
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setConnectTimeout(com.baidu.adp.framework.c.b.dr().ds().dv());
        httpURLConnection.setReadTimeout(com.baidu.adp.framework.c.b.dr().du().dv());
        for (Map.Entry<String, String> entry : this.acM.entrySet()) {
            httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
        }
        httpURLConnection.connect();
        this.responseCode = httpURLConnection.getResponseCode();
        this.acN = httpURLConnection.getHeaderFields();
        return o.i(httpURLConnection.getInputStream());
    }
}

package com.baidu.tbadk.core.hybrid;

import android.text.TextUtils;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class y {
    private Map<String, String> acs = new HashMap();
    private Map<String, List<String>> act;
    private int responseCode;
    private String url;

    public void setUrl(String str) {
        this.url = str;
    }

    public int getResponseCode() {
        return this.responseCode;
    }

    public Map<String, List<String>> tO() {
        return this.act;
    }

    public void addHeader(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.acs.put(str, str2);
        }
    }

    public byte[] tP() {
        int retryCount = com.baidu.adp.framework.c.b.ds().getRetryCount();
        for (int i = 0; i < retryCount; i++) {
            try {
                return tQ();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private byte[] tQ() throws Exception {
        if (TextUtils.isEmpty(this.url)) {
            return null;
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.url).openConnection();
        httpURLConnection.setDoInput(true);
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setConnectTimeout(com.baidu.adp.framework.c.b.ds().dt().dw());
        httpURLConnection.setReadTimeout(com.baidu.adp.framework.c.b.ds().dv().dw());
        for (Map.Entry<String, String> entry : this.acs.entrySet()) {
            httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
        }
        httpURLConnection.connect();
        this.responseCode = httpURLConnection.getResponseCode();
        this.act = httpURLConnection.getHeaderFields();
        return r.i(httpURLConnection.getInputStream());
    }
}

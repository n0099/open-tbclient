package com.baidu.livesdk.api.http;

import java.util.HashMap;
/* loaded from: classes2.dex */
public class HttpRequestEntity {
    public int connectTimeout;
    public HashMap<String, String> header;
    public String mediaType;
    public int method;
    public HashMap<String, String> postParams;
    public int readTimeout;
    public int retryCount;
    public String url;

    public int getConnectTimeout() {
        return this.connectTimeout;
    }

    public HashMap<String, String> getHeader() {
        return this.header;
    }

    public String getMediaType() {
        return this.mediaType;
    }

    public int getMethod() {
        return this.method;
    }

    public HashMap<String, String> getPostParams() {
        return this.postParams;
    }

    public int getReadTimeout() {
        return this.readTimeout;
    }

    public int getRetryCount() {
        return this.retryCount;
    }

    public String getUrl() {
        return this.url;
    }

    public void setConnectTimeout(int i2) {
        this.connectTimeout = i2;
    }

    public void setHeader(HashMap<String, String> hashMap) {
        this.header = hashMap;
    }

    public void setMediaType(String str) {
        this.mediaType = str;
    }

    public void setMethod(int i2) {
        this.method = i2;
    }

    public void setPostParams(HashMap<String, String> hashMap) {
        this.postParams = hashMap;
    }

    public void setReadTimeout(int i2) {
        this.readTimeout = i2;
    }

    public void setRetryCount(int i2) {
        this.retryCount = i2;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}

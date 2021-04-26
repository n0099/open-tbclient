package com.baidu.livesdk.api.http;

import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class HttpResponse {
    public String content;
    public Map<String, List<String>> headers;
    public int responseCode = 0;

    public String getContent() {
        return this.content;
    }

    public Map<String, List<String>> getHeaders() {
        return this.headers;
    }

    public int getResponseCode() {
        return this.responseCode;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setHeaders(Map<String, List<String>> map) {
        this.headers = map;
    }

    public void setResponseCode(int i2) {
        this.responseCode = i2;
    }
}

package com.baidu.tbadk.core.util.httpNet;

import java.util.HashMap;
/* loaded from: classes3.dex */
public class HttpNetContext {
    public HttpRequest request = new HttpRequest();
    public HttpResponse response = new HttpResponse();
    public HttpStat stat = new HttpStat();
    public HashMap<String, String> performanceData = new HashMap<>();

    public HashMap<String, String> getPerformance() {
        return this.performanceData;
    }

    public HttpRequest getRequest() {
        return this.request;
    }

    public HttpResponse getResponse() {
        return this.response;
    }

    public HttpStat getStat() {
        return this.stat;
    }
}

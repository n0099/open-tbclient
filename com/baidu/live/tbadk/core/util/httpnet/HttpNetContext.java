package com.baidu.live.tbadk.core.util.httpnet;
/* loaded from: classes4.dex */
public class HttpNetContext {
    private HttpRequest request = new HttpRequest();
    private HttpResponse response = new HttpResponse();
    private HttpStat stat = new HttpStat();

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

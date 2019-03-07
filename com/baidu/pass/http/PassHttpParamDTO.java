package com.baidu.pass.http;

import java.net.HttpCookie;
import java.util.List;
/* loaded from: classes3.dex */
public class PassHttpParamDTO {
    public int connectTimeout;
    public List<HttpCookie> cookie;
    public String url;
    public String userAgent;
    public HttpHashMap paramsMap = new HttpHashMap();
    public boolean asyncCookie = false;
}

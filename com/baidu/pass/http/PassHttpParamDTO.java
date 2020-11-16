package com.baidu.pass.http;

import java.net.HttpCookie;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes10.dex */
public class PassHttpParamDTO implements com.baidu.pass.a {
    public int connectTimeout;
    public List<HttpCookie> cookie;
    public String url;
    public String userAgent;
    public HttpHashMap paramsMap = new HttpHashMap();
    public boolean asyncCookie = false;
    public HashMap<String, String> headers = new HashMap<>(1);
}

package com.baidu.searchbox.http;

import com.baidu.searchbox.http.IHttpContext;
/* loaded from: classes2.dex */
public class HttpRuntime {
    public static IHttpContext getHttpContext() {
        return new IHttpContext.DefaultHttpContextImpl();
    }
}

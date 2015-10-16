package com.baidu.tbadk.core.util.a;

import org.apache.http.HttpResponse;
import org.apache.http.impl.client.DefaultRedirectHandler;
import org.apache.http.protocol.HttpContext;
/* loaded from: classes.dex */
class g extends DefaultRedirectHandler {
    public boolean isRedirectRequested(HttpResponse httpResponse, HttpContext httpContext) {
        return false;
    }
}

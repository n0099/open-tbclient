package com.alipay.android.phone.mrpc.core;

import org.apache.http.HttpResponse;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.protocol.HttpContext;
/* loaded from: classes.dex */
public final class f implements ConnectionKeepAliveStrategy {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d f1657a;

    public f(d dVar) {
        this.f1657a = dVar;
    }

    @Override // org.apache.http.conn.ConnectionKeepAliveStrategy
    public final long getKeepAliveDuration(HttpResponse httpResponse, HttpContext httpContext) {
        return 180000L;
    }
}

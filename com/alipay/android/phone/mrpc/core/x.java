package com.alipay.android.phone.mrpc.core;

import java.lang.reflect.Proxy;
/* loaded from: classes.dex */
public final class x {

    /* renamed from: a  reason: collision with root package name */
    public g f1670a;

    /* renamed from: b  reason: collision with root package name */
    public z f1671b = new z(this);

    public x(g gVar) {
        this.f1670a = gVar;
    }

    public final g a() {
        return this.f1670a;
    }

    public final <T> T a(Class<T> cls) {
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new y(this.f1670a, cls, this.f1671b));
    }
}

package com.alipay.android.phone.mrpc.core;

import java.lang.reflect.Proxy;
/* loaded from: classes.dex */
public final class x {

    /* renamed from: a  reason: collision with root package name */
    public g f1728a;

    /* renamed from: b  reason: collision with root package name */
    public z f1729b = new z(this);

    public x(g gVar) {
        this.f1728a = gVar;
    }

    public final g a() {
        return this.f1728a;
    }

    public final <T> T a(Class<T> cls) {
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new y(this.f1728a, cls, this.f1729b));
    }
}

package com.alipay.android.phone.mrpc.core;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public final class y implements InvocationHandler {

    /* renamed from: a  reason: collision with root package name */
    public g f1705a;

    /* renamed from: b  reason: collision with root package name */
    public Class<?> f1706b;

    /* renamed from: c  reason: collision with root package name */
    public z f1707c;

    public y(g gVar, Class<?> cls, z zVar) {
        this.f1705a = gVar;
        this.f1706b = cls;
        this.f1707c = zVar;
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        return this.f1707c.a(method, objArr);
    }
}

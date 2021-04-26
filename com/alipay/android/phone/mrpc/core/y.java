package com.alipay.android.phone.mrpc.core;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public final class y implements InvocationHandler {

    /* renamed from: a  reason: collision with root package name */
    public g f1672a;

    /* renamed from: b  reason: collision with root package name */
    public Class<?> f1673b;

    /* renamed from: c  reason: collision with root package name */
    public z f1674c;

    public y(g gVar, Class<?> cls, z zVar) {
        this.f1672a = gVar;
        this.f1673b = cls;
        this.f1674c = zVar;
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        return this.f1674c.a(method, objArr);
    }
}

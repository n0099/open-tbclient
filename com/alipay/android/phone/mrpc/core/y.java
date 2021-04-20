package com.alipay.android.phone.mrpc.core;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public final class y implements InvocationHandler {

    /* renamed from: a  reason: collision with root package name */
    public g f1730a;

    /* renamed from: b  reason: collision with root package name */
    public Class<?> f1731b;

    /* renamed from: c  reason: collision with root package name */
    public z f1732c;

    public y(g gVar, Class<?> cls, z zVar) {
        this.f1730a = gVar;
        this.f1731b = cls;
        this.f1732c = zVar;
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        return this.f1732c.a(method, objArr);
    }
}

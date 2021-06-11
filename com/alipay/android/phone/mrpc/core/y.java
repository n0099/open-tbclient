package com.alipay.android.phone.mrpc.core;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public final class y implements InvocationHandler {

    /* renamed from: a  reason: collision with root package name */
    public g f1685a;

    /* renamed from: b  reason: collision with root package name */
    public Class<?> f1686b;

    /* renamed from: c  reason: collision with root package name */
    public z f1687c;

    public y(g gVar, Class<?> cls, z zVar) {
        this.f1685a = gVar;
        this.f1686b = cls;
        this.f1687c = zVar;
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        return this.f1687c.a(method, objArr);
    }
}

package com.baidu.apollon.eventbus;

import com.baidu.apollon.eventbus.EventBus;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public final Object f3656a;

    /* renamed from: b  reason: collision with root package name */
    public final Method f3657b;

    /* renamed from: c  reason: collision with root package name */
    public final int f3658c;

    /* renamed from: d  reason: collision with root package name */
    public final String f3659d;

    /* renamed from: e  reason: collision with root package name */
    public final EventBus.ThreadMode f3660e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f3661f = true;

    public g(Object obj, Method method, String str, int i, EventBus.ThreadMode threadMode) {
        this.f3656a = obj;
        this.f3657b = method;
        this.f3659d = str;
        this.f3658c = i;
        this.f3660e = threadMode;
    }

    public boolean equals(Object obj) {
        if (obj instanceof g) {
            g gVar = (g) obj;
            return this.f3656a == gVar.f3656a && this.f3657b.equals(gVar.f3657b);
        }
        return false;
    }

    public int hashCode() {
        return this.f3656a.hashCode() + this.f3657b.hashCode();
    }
}

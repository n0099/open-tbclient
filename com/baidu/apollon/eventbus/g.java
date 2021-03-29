package com.baidu.apollon.eventbus;

import com.baidu.apollon.eventbus.EventBus;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public final Object f3621a;

    /* renamed from: b  reason: collision with root package name */
    public final Method f3622b;

    /* renamed from: c  reason: collision with root package name */
    public final int f3623c;

    /* renamed from: d  reason: collision with root package name */
    public final String f3624d;

    /* renamed from: e  reason: collision with root package name */
    public final EventBus.ThreadMode f3625e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f3626f = true;

    public g(Object obj, Method method, String str, int i, EventBus.ThreadMode threadMode) {
        this.f3621a = obj;
        this.f3622b = method;
        this.f3624d = str;
        this.f3623c = i;
        this.f3625e = threadMode;
    }

    public boolean equals(Object obj) {
        if (obj instanceof g) {
            g gVar = (g) obj;
            return this.f3621a == gVar.f3621a && this.f3622b.equals(gVar.f3622b);
        }
        return false;
    }

    public int hashCode() {
        return this.f3621a.hashCode() + this.f3622b.hashCode();
    }
}

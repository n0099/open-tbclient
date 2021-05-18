package com.baidu.apollon.eventbus;

import com.baidu.apollon.eventbus.EventBus;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public final Object f3701a;

    /* renamed from: b  reason: collision with root package name */
    public final Method f3702b;

    /* renamed from: c  reason: collision with root package name */
    public final int f3703c;

    /* renamed from: d  reason: collision with root package name */
    public final String f3704d;

    /* renamed from: e  reason: collision with root package name */
    public final EventBus.ThreadMode f3705e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f3706f = true;

    public g(Object obj, Method method, String str, int i2, EventBus.ThreadMode threadMode) {
        this.f3701a = obj;
        this.f3702b = method;
        this.f3704d = str;
        this.f3703c = i2;
        this.f3705e = threadMode;
    }

    public boolean equals(Object obj) {
        if (obj instanceof g) {
            g gVar = (g) obj;
            return this.f3701a == gVar.f3701a && this.f3702b.equals(gVar.f3702b);
        }
        return false;
    }

    public int hashCode() {
        return this.f3701a.hashCode() + this.f3702b.hashCode();
    }
}

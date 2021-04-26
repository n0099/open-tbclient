package com.baidu.apollon.eventbus;

import com.baidu.apollon.eventbus.EventBus;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public final Object f3700a;

    /* renamed from: b  reason: collision with root package name */
    public final Method f3701b;

    /* renamed from: c  reason: collision with root package name */
    public final int f3702c;

    /* renamed from: d  reason: collision with root package name */
    public final String f3703d;

    /* renamed from: e  reason: collision with root package name */
    public final EventBus.ThreadMode f3704e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f3705f = true;

    public g(Object obj, Method method, String str, int i2, EventBus.ThreadMode threadMode) {
        this.f3700a = obj;
        this.f3701b = method;
        this.f3703d = str;
        this.f3702c = i2;
        this.f3704e = threadMode;
    }

    public boolean equals(Object obj) {
        if (obj instanceof g) {
            g gVar = (g) obj;
            return this.f3700a == gVar.f3700a && this.f3701b.equals(gVar.f3701b);
        }
        return false;
    }

    public int hashCode() {
        return this.f3700a.hashCode() + this.f3701b.hashCode();
    }
}

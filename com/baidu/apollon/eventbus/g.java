package com.baidu.apollon.eventbus;

import com.baidu.apollon.eventbus.EventBus;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public final Object f3620a;

    /* renamed from: b  reason: collision with root package name */
    public final Method f3621b;

    /* renamed from: c  reason: collision with root package name */
    public final int f3622c;

    /* renamed from: d  reason: collision with root package name */
    public final String f3623d;

    /* renamed from: e  reason: collision with root package name */
    public final EventBus.ThreadMode f3624e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f3625f = true;

    public g(Object obj, Method method, String str, int i, EventBus.ThreadMode threadMode) {
        this.f3620a = obj;
        this.f3621b = method;
        this.f3623d = str;
        this.f3622c = i;
        this.f3624e = threadMode;
    }

    public boolean equals(Object obj) {
        if (obj instanceof g) {
            g gVar = (g) obj;
            return this.f3620a == gVar.f3620a && this.f3621b.equals(gVar.f3621b);
        }
        return false;
    }

    public int hashCode() {
        return this.f3620a.hashCode() + this.f3621b.hashCode();
    }
}

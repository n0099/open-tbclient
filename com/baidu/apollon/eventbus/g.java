package com.baidu.apollon.eventbus;

import com.baidu.apollon.eventbus.EventBus;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public final Object f3723a;

    /* renamed from: b  reason: collision with root package name */
    public final Method f3724b;

    /* renamed from: c  reason: collision with root package name */
    public final int f3725c;

    /* renamed from: d  reason: collision with root package name */
    public final String f3726d;

    /* renamed from: e  reason: collision with root package name */
    public final EventBus.ThreadMode f3727e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f3728f = true;

    public g(Object obj, Method method, String str, int i2, EventBus.ThreadMode threadMode) {
        this.f3723a = obj;
        this.f3724b = method;
        this.f3726d = str;
        this.f3725c = i2;
        this.f3727e = threadMode;
    }

    public boolean equals(Object obj) {
        if (obj instanceof g) {
            g gVar = (g) obj;
            return this.f3723a == gVar.f3723a && this.f3724b.equals(gVar.f3724b);
        }
        return false;
    }

    public int hashCode() {
        return this.f3723a.hashCode() + this.f3724b.hashCode();
    }
}

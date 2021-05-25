package com.baidu.apollon.eventbus;

import com.baidu.apollon.eventbus.EventBus;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public final Object f3704a;

    /* renamed from: b  reason: collision with root package name */
    public final Method f3705b;

    /* renamed from: c  reason: collision with root package name */
    public final int f3706c;

    /* renamed from: d  reason: collision with root package name */
    public final String f3707d;

    /* renamed from: e  reason: collision with root package name */
    public final EventBus.ThreadMode f3708e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f3709f = true;

    public g(Object obj, Method method, String str, int i2, EventBus.ThreadMode threadMode) {
        this.f3704a = obj;
        this.f3705b = method;
        this.f3707d = str;
        this.f3706c = i2;
        this.f3708e = threadMode;
    }

    public boolean equals(Object obj) {
        if (obj instanceof g) {
            g gVar = (g) obj;
            return this.f3704a == gVar.f3704a && this.f3705b.equals(gVar.f3705b);
        }
        return false;
    }

    public int hashCode() {
        return this.f3704a.hashCode() + this.f3705b.hashCode();
    }
}

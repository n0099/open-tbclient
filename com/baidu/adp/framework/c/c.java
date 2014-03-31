package com.baidu.adp.framework.c;

import com.baidu.adp.framework.message.f;
/* loaded from: classes.dex */
public abstract class c<T extends com.baidu.adp.framework.message.f<?>> extends com.baidu.adp.framework.e {
    private int a;
    private int b = 0;

    public abstract void a(T t);

    public c(int i) {
        this.a = 0;
        this.a = i;
    }

    public final int b() {
        return this.a;
    }

    public final int c() {
        return this.b;
    }

    public final void b(int i) {
        this.b = i;
    }
}

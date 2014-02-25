package com.baidu.adp.framework.c;

import com.baidu.adp.framework.message.f;
/* loaded from: classes.dex */
public abstract class c<T extends f<?>> extends com.baidu.adp.framework.d {
    private int a;
    private int b;

    public abstract void a(T t);

    public int b() {
        return this.a;
    }

    public int c() {
        return this.b;
    }

    public void a(int i) {
        this.b = i;
    }
}

package com.baidu.adp.framework.message;
/* loaded from: classes.dex */
public abstract class f<T> implements d<T> {
    private final int a;
    private e<?> b;
    private int c = 0;
    private String d = null;

    public final void a(int i) {
        this.c = i;
    }

    public final void a(String str) {
        this.d = str;
    }

    public f(int i) {
        this.a = i;
    }

    public final int b() {
        return this.a;
    }

    public final void a(e<?> eVar) {
        this.b = eVar;
    }
}

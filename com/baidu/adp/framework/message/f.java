package com.baidu.adp.framework.message;
/* loaded from: classes.dex */
public abstract class f<T> implements c<T> {
    private final int a;
    private d<?> b;
    private int c = 0;
    private String d = null;

    public final int e() {
        return this.c;
    }

    public final void a(int i) {
        this.c = i;
    }

    public final String f() {
        return this.d;
    }

    public final void e(String str) {
        this.d = str;
    }

    public f(int i) {
        this.a = i;
    }

    public final int g() {
        return this.a;
    }

    public final d<?> h() {
        return this.b;
    }

    public final void a(d<?> dVar) {
        this.b = dVar;
    }

    public void b(int i, T t) {
    }
}

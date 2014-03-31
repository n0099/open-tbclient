package com.baidu.adp.framework.message;

import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public abstract class d<T> {
    private final int a;
    private int b;
    private Object c = null;

    public abstract boolean a(int i);

    public d(int i) {
        this.a = i;
        if (!a(this.a)) {
            throw new InvalidParameterException("cmd invalid");
        }
    }

    public final int e() {
        return this.a;
    }

    public final int f() {
        return this.b;
    }

    public final void b(int i) {
        this.b = i;
    }

    public final Object g() {
        return this.c;
    }

    public final void b(Object obj) {
        this.c = obj;
    }
}

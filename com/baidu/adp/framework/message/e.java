package com.baidu.adp.framework.message;

import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public abstract class e<T> {
    private final int a;
    private int b;

    public abstract boolean a(int i);

    public e(int i) {
        this.a = i;
        if (!a(this.a)) {
            throw new InvalidParameterException("cmd invalid");
        }
    }

    public final int d() {
        return this.a;
    }

    public final int e() {
        return this.b;
    }

    public final void b(int i) {
        this.b = i;
    }
}

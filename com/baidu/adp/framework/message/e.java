package com.baidu.adp.framework.message;

import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public abstract class e<T> {
    private final int a;
    private int b;

    public abstract boolean a(int i);

    public e(int i) {
        this.a = i;
        a();
    }

    private void a() {
        if (!a(this.a)) {
            throw new InvalidParameterException("cmd invalid");
        }
    }

    public int d() {
        return this.a;
    }

    public int e() {
        return this.b;
    }

    public void b(int i) {
        this.b = i;
    }
}

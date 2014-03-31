package com.baidu.adp.framework.c;

import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public abstract class d {
    private b a;
    private g b;

    public abstract void a(com.baidu.adp.framework.message.f<?> fVar);

    public d(int i) {
        this.a = null;
        this.b = null;
        this.a = new e(this, 1001);
        this.b = new f(this, 1001);
    }

    public final b a() {
        return this.a;
    }

    public final g b() {
        return this.b;
    }

    public final int c() {
        if (this.a.c() != this.b.c()) {
            throw new InvalidParameterException("tag invalid");
        }
        return this.a.c();
    }

    public final void a(int i) {
        this.a.b(i);
        this.b.b(i);
    }
}

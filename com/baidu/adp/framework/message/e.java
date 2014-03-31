package com.baidu.adp.framework.message;

import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public final class e {
    private HttpMessage a;
    private g b;

    public final HttpMessage a() {
        return this.a;
    }

    public final g b() {
        return this.b;
    }

    public final int c() {
        if (this.a.f() != this.b.f()) {
            throw new InvalidParameterException("tag invalid");
        }
        return this.a.f();
    }

    public final void a(int i) {
        this.a.b(i);
        this.b.b(i);
    }
}

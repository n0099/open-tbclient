package com.baidu.adp.framework.task;

import com.baidu.adp.framework.e.f;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public abstract class b {
    protected final int a;
    protected f b;
    protected int c;
    protected int d;

    public abstract boolean b();

    public b(int i) {
        this.a = i;
        if (!b()) {
            throw new InvalidParameterException("cmd invalid");
        }
    }

    public final int i() {
        return this.a;
    }

    public final f j() {
        return this.b;
    }

    public final void b(f fVar) {
        this.b = fVar;
    }

    public final int k() {
        return this.c;
    }

    public final void a(int i) {
        this.c = i;
    }

    public final int l() {
        return this.d;
    }

    public final void b(int i) {
        this.d = -3;
    }
}

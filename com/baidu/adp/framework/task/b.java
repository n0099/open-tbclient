package com.baidu.adp.framework.task;

import com.baidu.adp.framework.e.e;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public abstract class b {
    protected final int a;
    protected e b;
    protected int c;
    protected int d;

    public abstract boolean b();

    public b(int i) {
        this.a = i;
        a();
    }

    private void a() {
        if (!b()) {
            throw new InvalidParameterException("cmd invalid");
        }
    }

    public int i() {
        return this.a;
    }

    public e j() {
        return this.b;
    }

    public void b(e eVar) {
        this.b = eVar;
    }

    public int k() {
        return this.c;
    }

    public void a(int i) {
        this.c = i;
    }

    public int l() {
        return this.d;
    }
}

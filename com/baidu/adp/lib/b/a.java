package com.baidu.adp.lib.b;

import com.baidu.adp.lib.b.c;
/* loaded from: classes.dex */
public abstract class a {
    protected String mName;
    protected String[] ud;
    protected int ue = 0;
    protected int uf = 1;
    protected int ug = 10;
    protected c.a uh = new b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void X(int i);

    protected abstract String[] eQ();

    protected abstract int eR();

    protected abstract int eS();

    protected abstract int eT();

    protected abstract String getName();

    protected String[] eU() {
        return null;
    }

    protected void eV() {
        c cVar = new c(this.mName, this.ue, this.uh);
        cVar.a(this.ug, this.ud, this.uf);
        cVar.g(eU());
        e.eZ().a(cVar);
    }

    public a() {
        initData();
        eV();
    }

    protected void initData() {
        this.mName = getName();
        this.ud = eQ();
        this.ue = eR();
        this.uf = eS();
        this.ug = eT();
    }
}

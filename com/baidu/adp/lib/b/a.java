package com.baidu.adp.lib.b;

import com.baidu.adp.lib.b.c;
/* loaded from: classes.dex */
public abstract class a {
    protected String mName;
    protected String[] uc;
    protected int ud = 0;
    protected int ue = 1;
    protected int uf = 10;
    protected c.a ug = new b(this);

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
        c cVar = new c(this.mName, this.ud, this.ug);
        cVar.a(this.uf, this.uc, this.ue);
        cVar.g(eU());
        e.eZ().a(cVar);
    }

    public a() {
        initData();
        eV();
    }

    protected void initData() {
        this.mName = getName();
        this.uc = eQ();
        this.ud = eR();
        this.ue = eS();
        this.uf = eT();
    }
}

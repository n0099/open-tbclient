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

    protected abstract String[] eP();

    protected abstract int eQ();

    protected abstract int eR();

    protected abstract int eS();

    protected abstract String getName();

    protected String[] eT() {
        return null;
    }

    protected void eU() {
        c cVar = new c(this.mName, this.ud, this.ug);
        cVar.a(this.uf, this.uc, this.ue);
        cVar.g(eT());
        e.eY().a(cVar);
    }

    public a() {
        initData();
        eU();
    }

    protected void initData() {
        this.mName = getName();
        this.uc = eP();
        this.ud = eQ();
        this.ue = eR();
        this.uf = eS();
    }
}

package com.baidu.adp.lib.b;

import com.baidu.adp.lib.b.c;
/* loaded from: classes.dex */
public abstract class a {
    protected String mName;
    protected String[] tW;
    protected int tX = 0;
    protected int tY = 1;
    protected int tZ = 10;
    protected c.a ub = new b(this);

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
        c cVar = new c(this.mName, this.tX, this.ub);
        cVar.a(this.tZ, this.tW, this.tY);
        cVar.g(eT());
        e.eY().a(cVar);
    }

    public a() {
        initData();
        eU();
    }

    protected void initData() {
        this.mName = getName();
        this.tW = eP();
        this.tX = eQ();
        this.tY = eR();
        this.tZ = eS();
    }
}

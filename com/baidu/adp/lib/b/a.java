package com.baidu.adp.lib.b;

import com.baidu.adp.lib.b.b;
/* loaded from: classes.dex */
public abstract class a {
    protected String mName;
    protected String[] tA;
    protected int tB = 0;
    protected int tC = 1;
    protected int tD = 10;
    protected b.a tE = new b.a() { // from class: com.baidu.adp.lib.b.a.1
        @Override // com.baidu.adp.lib.b.b.a
        public void a(String str, int i, boolean z) {
            a.this.X(i);
        }
    };

    protected abstract void X(int i);

    protected abstract String[] eM();

    protected abstract int eN();

    protected abstract int eO();

    protected abstract int eP();

    protected abstract String getName();

    protected String[] eQ() {
        return null;
    }

    protected void eR() {
        b bVar = new b(this.mName, this.tB, this.tE);
        bVar.a(this.tD, this.tA, this.tC);
        bVar.g(eQ());
        d.eV().a(bVar);
    }

    public a() {
        initData();
        eR();
    }

    protected void initData() {
        this.mName = getName();
        this.tA = eM();
        this.tB = eN();
        this.tC = eO();
        this.tD = eP();
    }
}

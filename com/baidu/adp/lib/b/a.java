package com.baidu.adp.lib.b;

import com.baidu.adp.lib.b.b;
/* loaded from: classes.dex */
public abstract class a {
    protected String mName;
    protected int tA = 0;
    protected int tB = 1;
    protected int tC = 10;
    protected b.a tD = new b.a() { // from class: com.baidu.adp.lib.b.a.1
        @Override // com.baidu.adp.lib.b.b.a
        public void a(String str, int i, boolean z) {
            a.this.X(i);
        }
    };
    protected String[] tz;

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
        b bVar = new b(this.mName, this.tA, this.tD);
        bVar.a(this.tC, this.tz, this.tB);
        bVar.g(eQ());
        d.eV().a(bVar);
    }

    public a() {
        initData();
        eR();
    }

    protected void initData() {
        this.mName = getName();
        this.tz = eM();
        this.tA = eN();
        this.tB = eO();
        this.tC = eP();
    }
}

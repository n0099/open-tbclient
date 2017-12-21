package com.baidu.adp.lib.b;

import com.baidu.adp.lib.b.b;
/* loaded from: classes.dex */
public abstract class a {
    protected String mName;
    protected String[] tw;
    protected int tz = 0;
    protected int tA = 1;
    protected int tB = 10;
    protected b.a tC = new b.a() { // from class: com.baidu.adp.lib.b.a.1
        @Override // com.baidu.adp.lib.b.b.a
        public void a(String str, int i, boolean z) {
            a.this.W(i);
        }
    };

    protected abstract void W(int i);

    protected abstract String[] eM();

    protected abstract int eN();

    protected abstract int eO();

    protected abstract int eP();

    protected abstract String getName();

    protected String[] eQ() {
        return null;
    }

    protected void eR() {
        b bVar = new b(this.mName, this.tz, this.tC);
        bVar.a(this.tB, this.tw, this.tA);
        bVar.g(eQ());
        d.eV().a(bVar);
    }

    public a() {
        initData();
        eR();
    }

    protected void initData() {
        this.mName = getName();
        this.tw = eM();
        this.tz = eN();
        this.tA = eO();
        this.tB = eP();
    }
}

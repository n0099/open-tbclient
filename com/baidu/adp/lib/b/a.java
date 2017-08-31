package com.baidu.adp.lib.b;

import com.baidu.adp.lib.b.b;
/* loaded from: classes.dex */
public abstract class a {
    protected String mName;
    protected String[] tx;
    protected int ty = 0;
    protected int tz = 1;
    protected int tA = 10;
    protected b.a tB = new b.a() { // from class: com.baidu.adp.lib.b.a.1
        @Override // com.baidu.adp.lib.b.b.a
        public void a(String str, int i, boolean z) {
            a.this.X(i);
        }
    };

    protected abstract void X(int i);

    protected abstract String[] eN();

    protected abstract int eO();

    protected abstract int eP();

    protected abstract int eQ();

    protected abstract String getName();

    protected String[] eR() {
        return null;
    }

    protected void eS() {
        b bVar = new b(this.mName, this.ty, this.tB);
        bVar.a(this.tA, this.tx, this.tz);
        bVar.g(eR());
        d.eW().a(bVar);
    }

    public a() {
        initData();
        eS();
    }

    protected void initData() {
        this.mName = getName();
        this.tx = eN();
        this.ty = eO();
        this.tz = eP();
        this.tA = eQ();
    }
}

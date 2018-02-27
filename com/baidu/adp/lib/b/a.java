package com.baidu.adp.lib.b;

import com.baidu.adp.lib.b.b;
/* loaded from: classes.dex */
public abstract class a {
    protected String[] ahI;
    protected int ahJ = 0;
    protected int ahK = 1;
    protected int ahL = 10;
    protected b.a ahM = new b.a() { // from class: com.baidu.adp.lib.b.a.1
        @Override // com.baidu.adp.lib.b.b.a
        public void a(String str, int i, boolean z) {
            a.this.cQ(i);
        }
    };
    protected String mName;

    protected abstract void cQ(int i);

    protected abstract String getName();

    protected abstract String[] mr();

    protected abstract int ms();

    protected abstract int mt();

    protected abstract int mu();

    protected String[] mv() {
        return null;
    }

    protected void mw() {
        b bVar = new b(this.mName, this.ahJ, this.ahM);
        bVar.a(this.ahL, this.ahI, this.ahK);
        bVar.g(mv());
        d.mA().a(bVar);
    }

    public a() {
        initData();
        mw();
    }

    protected void initData() {
        this.mName = getName();
        this.ahI = mr();
        this.ahJ = ms();
        this.ahK = mt();
        this.ahL = mu();
    }
}

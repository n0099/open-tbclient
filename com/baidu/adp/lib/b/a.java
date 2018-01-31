package com.baidu.adp.lib.b;

import com.baidu.adp.lib.b.b;
/* loaded from: classes.dex */
public abstract class a {
    protected String[] ahQ;
    protected int ahR = 0;
    protected int ahS = 1;
    protected int ahT = 10;
    protected b.a ahU = new b.a() { // from class: com.baidu.adp.lib.b.a.1
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
        b bVar = new b(this.mName, this.ahR, this.ahU);
        bVar.a(this.ahT, this.ahQ, this.ahS);
        bVar.g(mv());
        d.mA().a(bVar);
    }

    public a() {
        initData();
        mw();
    }

    protected void initData() {
        this.mName = getName();
        this.ahQ = mr();
        this.ahR = ms();
        this.ahS = mt();
        this.ahT = mu();
    }
}

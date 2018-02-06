package com.baidu.adp.lib.b;

import com.baidu.adp.lib.b.b;
/* loaded from: classes.dex */
public abstract class a {
    protected String[] ahO;
    protected int ahP = 0;
    protected int ahQ = 1;
    protected int ahR = 10;
    protected b.a ahS = new b.a() { // from class: com.baidu.adp.lib.b.a.1
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
        b bVar = new b(this.mName, this.ahP, this.ahS);
        bVar.a(this.ahR, this.ahO, this.ahQ);
        bVar.g(mv());
        d.mA().a(bVar);
    }

    public a() {
        initData();
        mw();
    }

    protected void initData() {
        this.mName = getName();
        this.ahO = mr();
        this.ahP = ms();
        this.ahQ = mt();
        this.ahR = mu();
    }
}

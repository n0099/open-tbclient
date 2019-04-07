package com.baidu.adp.lib.b;

import com.baidu.adp.lib.b.b;
/* loaded from: classes.dex */
public abstract class a {
    protected String[] Bl;
    protected int Bm = 0;
    protected int Bn = 1;
    protected int Bo = 10;
    protected b.a Bp = new b.a() { // from class: com.baidu.adp.lib.b.a.1
        @Override // com.baidu.adp.lib.b.b.a
        public void a(String str, int i, boolean z) {
            a.this.Y(i);
        }
    };
    protected String mName;

    protected abstract void Y(int i);

    protected abstract String getName();

    protected abstract String[] iG();

    protected abstract int iH();

    protected abstract int iI();

    protected abstract int iJ();

    /* JADX INFO: Access modifiers changed from: protected */
    public String[] iK() {
        return null;
    }

    protected void iL() {
        b bVar = new b(this.mName, this.Bm, this.Bp);
        bVar.a(this.Bo, this.Bl, this.Bn);
        bVar.h(iK());
        d.iQ().a(bVar);
    }

    public a() {
        initData();
        iL();
    }

    protected void initData() {
        this.mName = getName();
        this.Bl = iG();
        this.Bm = iH();
        this.Bn = iI();
        this.Bo = iJ();
    }
}

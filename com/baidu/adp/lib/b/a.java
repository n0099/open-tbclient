package com.baidu.adp.lib.b;

import com.baidu.adp.lib.b.b;
/* loaded from: classes.dex */
public abstract class a {
    protected String[] Bm;
    protected int Bn = 0;
    protected int Bo = 1;
    protected int Bp = 10;
    protected b.a Bq = new b.a() { // from class: com.baidu.adp.lib.b.a.1
        @Override // com.baidu.adp.lib.b.b.a
        public void a(String str, int i, boolean z) {
            a.this.Z(i);
        }
    };
    protected String mName;

    protected abstract void Z(int i);

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
        b bVar = new b(this.mName, this.Bn, this.Bq);
        bVar.a(this.Bp, this.Bm, this.Bo);
        bVar.h(iK());
        d.iQ().a(bVar);
    }

    public a() {
        initData();
        iL();
    }

    protected void initData() {
        this.mName = getName();
        this.Bm = iG();
        this.Bn = iH();
        this.Bo = iI();
        this.Bp = iJ();
    }
}

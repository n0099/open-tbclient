package com.baidu.adp.lib.b;

import com.baidu.adp.lib.b.b;
/* loaded from: classes.dex */
public abstract class a {
    protected String[] Bn;
    protected int Bo = 0;
    protected int Bp = 1;
    protected int Bq = 10;
    protected b.a Br = new b.a() { // from class: com.baidu.adp.lib.b.a.1
        @Override // com.baidu.adp.lib.b.b.a
        public void a(String str, int i, boolean z) {
            a.this.aq(i);
        }
    };
    protected String mName;

    protected abstract void aq(int i);

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
        b bVar = new b(this.mName, this.Bo, this.Br);
        bVar.a(this.Bq, this.Bn, this.Bp);
        bVar.h(iK());
        d.iQ().a(bVar);
    }

    public a() {
        initData();
        iL();
    }

    protected void initData() {
        this.mName = getName();
        this.Bn = iG();
        this.Bo = iH();
        this.Bp = iI();
        this.Bq = iJ();
    }
}

package com.baidu.adp.lib.b;

import com.baidu.adp.lib.b.b;
/* loaded from: classes.dex */
public abstract class a {
    protected String[] Bk;
    protected int Bl = 0;
    protected int Bm = 1;
    protected int Bn = 10;
    protected b.a Bo = new b.a() { // from class: com.baidu.adp.lib.b.a.1
        @Override // com.baidu.adp.lib.b.b.a
        public void a(String str, int i, boolean z) {
            a.this.Z(i);
        }
    };
    protected String mName;

    protected abstract void Z(int i);

    protected abstract String getName();

    protected abstract String[] iH();

    protected abstract int iI();

    protected abstract int iJ();

    protected abstract int iK();

    /* JADX INFO: Access modifiers changed from: protected */
    public String[] iL() {
        return null;
    }

    protected void iM() {
        b bVar = new b(this.mName, this.Bl, this.Bo);
        bVar.a(this.Bn, this.Bk, this.Bm);
        bVar.h(iL());
        d.iR().a(bVar);
    }

    public a() {
        initData();
        iM();
    }

    protected void initData() {
        this.mName = getName();
        this.Bk = iH();
        this.Bl = iI();
        this.Bm = iJ();
        this.Bn = iK();
    }
}

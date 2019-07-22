package com.baidu.adp.lib.b;

import com.baidu.adp.lib.b.b;
/* loaded from: classes.dex */
public abstract class a {
    protected String mName;
    protected String[] yZ;
    protected int za = 0;
    protected int zb = 1;
    protected int zc = 10;
    protected b.a zd = new b.a() { // from class: com.baidu.adp.lib.b.a.1
        @Override // com.baidu.adp.lib.b.b.a
        public void a(String str, int i, boolean z) {
            a.this.R(i);
        }
    };

    protected abstract void R(int i);

    protected abstract String getName();

    protected abstract String[] hI();

    protected abstract int hJ();

    protected abstract int hK();

    protected abstract int hL();

    /* JADX INFO: Access modifiers changed from: protected */
    public String[] hM() {
        return null;
    }

    protected void hN() {
        b bVar = new b(this.mName, this.za, this.zd);
        bVar.a(this.zc, this.yZ, this.zb);
        bVar.g(hM());
        d.hS().a(bVar);
    }

    public a() {
        initData();
        hN();
    }

    protected void initData() {
        this.mName = getName();
        this.yZ = hI();
        this.za = hJ();
        this.zb = hK();
        this.zc = hL();
    }
}

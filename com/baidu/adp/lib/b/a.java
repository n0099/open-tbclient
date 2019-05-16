package com.baidu.adp.lib.b;

import com.baidu.adp.lib.b.b;
/* loaded from: classes.dex */
public abstract class a {
    protected String mName;
    protected String[] yU;
    protected int yV = 0;
    protected int yW = 1;
    protected int yX = 10;
    protected b.a yY = new b.a() { // from class: com.baidu.adp.lib.b.a.1
        @Override // com.baidu.adp.lib.b.b.a
        public void a(String str, int i, boolean z) {
            a.this.R(i);
        }
    };

    protected abstract void R(int i);

    protected abstract String getName();

    protected abstract int hA();

    protected abstract int hB();

    protected abstract String[] hy();

    protected abstract int hz();

    /* JADX INFO: Access modifiers changed from: protected */
    public String[] hC() {
        return null;
    }

    protected void hD() {
        b bVar = new b(this.mName, this.yV, this.yY);
        bVar.a(this.yX, this.yU, this.yW);
        bVar.g(hC());
        d.hI().a(bVar);
    }

    public a() {
        initData();
        hD();
    }

    protected void initData() {
        this.mName = getName();
        this.yU = hy();
        this.yV = hz();
        this.yW = hA();
        this.yX = hB();
    }
}

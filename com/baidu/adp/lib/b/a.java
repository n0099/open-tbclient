package com.baidu.adp.lib.b;

import com.baidu.adp.lib.b.b;
/* loaded from: classes.dex */
public abstract class a {
    protected String mName;
    protected String[] yT;
    protected int yU = 0;
    protected int yV = 1;
    protected int yW = 10;
    protected b.a yX = new b.a() { // from class: com.baidu.adp.lib.b.a.1
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
        b bVar = new b(this.mName, this.yU, this.yX);
        bVar.a(this.yW, this.yT, this.yV);
        bVar.g(hC());
        d.hI().a(bVar);
    }

    public a() {
        initData();
        hD();
    }

    protected void initData() {
        this.mName = getName();
        this.yT = hy();
        this.yU = hz();
        this.yV = hA();
        this.yW = hB();
    }
}

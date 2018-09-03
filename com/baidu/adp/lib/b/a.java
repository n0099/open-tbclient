package com.baidu.adp.lib.b;

import com.baidu.adp.lib.b.b;
/* loaded from: classes.dex */
public abstract class a {
    protected String mName;
    protected String[] yg;
    protected int yh = 0;
    protected int yi = 1;
    protected int yj = 10;
    protected b.a yk = new b.a() { // from class: com.baidu.adp.lib.b.a.1
        @Override // com.baidu.adp.lib.b.b.a
        public void a(String str, int i, boolean z) {
            a.this.R(i);
        }
    };

    protected abstract void R(int i);

    protected abstract String getName();

    protected abstract String[] hl();

    protected abstract int hm();

    protected abstract int hn();

    protected abstract int ho();

    /* JADX INFO: Access modifiers changed from: protected */
    public String[] hp() {
        return null;
    }

    protected void hq() {
        b bVar = new b(this.mName, this.yh, this.yk);
        bVar.a(this.yj, this.yg, this.yi);
        bVar.g(hp());
        d.hv().a(bVar);
    }

    public a() {
        initData();
        hq();
    }

    protected void initData() {
        this.mName = getName();
        this.yg = hl();
        this.yh = hm();
        this.yi = hn();
        this.yj = ho();
    }
}

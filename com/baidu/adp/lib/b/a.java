package com.baidu.adp.lib.b;

import com.baidu.adp.lib.b.b;
/* loaded from: classes.dex */
public abstract class a {
    protected String mName;
    protected String[] yf;
    protected int yg = 0;
    protected int yh = 1;
    protected int yi = 10;
    protected b.a yj = new b.a() { // from class: com.baidu.adp.lib.b.a.1
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
        b bVar = new b(this.mName, this.yg, this.yj);
        bVar.a(this.yi, this.yf, this.yh);
        bVar.g(hp());
        d.hv().a(bVar);
    }

    public a() {
        initData();
        hq();
    }

    protected void initData() {
        this.mName = getName();
        this.yf = hl();
        this.yg = hm();
        this.yh = hn();
        this.yi = ho();
    }
}

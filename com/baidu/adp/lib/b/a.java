package com.baidu.adp.lib.b;

import com.baidu.adp.lib.b.b;
/* loaded from: classes.dex */
public abstract class a {
    protected String mName;
    protected String[] sa;
    protected int sb = 0;
    protected int sc = 1;
    protected int sd = 10;
    protected b.a se = new b.a() { // from class: com.baidu.adp.lib.b.a.1
        @Override // com.baidu.adp.lib.b.b.a
        public void a(String str, int i, boolean z) {
            a.this.Q(i);
        }
    };

    protected abstract void Q(int i);

    protected abstract String[] ev();

    protected abstract int ew();

    protected abstract int ex();

    protected abstract int ey();

    protected abstract String getName();

    protected String[] ez() {
        return null;
    }

    protected void eA() {
        b bVar = new b(this.mName, this.sb, this.se);
        bVar.a(this.sd, this.sa, this.sc);
        bVar.g(ez());
        d.eE().a(bVar);
    }

    public a() {
        initData();
        eA();
    }

    protected void initData() {
        this.mName = getName();
        this.sa = ev();
        this.sb = ew();
        this.sc = ex();
        this.sd = ey();
    }
}

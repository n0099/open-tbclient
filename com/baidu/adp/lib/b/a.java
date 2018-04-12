package com.baidu.adp.lib.b;

import com.baidu.adp.lib.b.b;
/* loaded from: classes.dex */
public abstract class a {
    protected String mName;
    protected String[] sb;
    protected int sc = 0;
    protected int sd = 1;
    protected int se = 10;
    protected b.a sf = new b.a() { // from class: com.baidu.adp.lib.b.a.1
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
        b bVar = new b(this.mName, this.sc, this.sf);
        bVar.a(this.se, this.sb, this.sd);
        bVar.g(ez());
        d.eE().a(bVar);
    }

    public a() {
        initData();
        eA();
    }

    protected void initData() {
        this.mName = getName();
        this.sb = ev();
        this.sc = ew();
        this.sd = ex();
        this.se = ey();
    }
}

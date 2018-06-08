package com.baidu.adp.lib.b;

import com.baidu.adp.lib.b.b;
/* loaded from: classes.dex */
public abstract class a {
    protected String mName;
    protected String[] yn;
    protected int yo = 0;
    protected int yp = 1;
    protected int yq = 10;
    protected b.a yr = new b.a() { // from class: com.baidu.adp.lib.b.a.1
        @Override // com.baidu.adp.lib.b.b.a
        public void a(String str, int i, boolean z) {
            a.this.R(i);
        }
    };

    protected abstract void R(int i);

    protected abstract String getName();

    protected abstract String[] hm();

    protected abstract int hn();

    protected abstract int ho();

    protected abstract int hp();

    protected String[] hq() {
        return null;
    }

    protected void hr() {
        b bVar = new b(this.mName, this.yo, this.yr);
        bVar.a(this.yq, this.yn, this.yp);
        bVar.g(hq());
        d.hv().a(bVar);
    }

    public a() {
        initData();
        hr();
    }

    protected void initData() {
        this.mName = getName();
        this.yn = hm();
        this.yo = hn();
        this.yp = ho();
        this.yq = hp();
    }
}

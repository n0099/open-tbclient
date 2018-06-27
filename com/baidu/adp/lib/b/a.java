package com.baidu.adp.lib.b;

import com.baidu.adp.lib.b.b;
/* loaded from: classes.dex */
public abstract class a {
    protected String mName;
    protected String[] yl;
    protected int ym = 0;
    protected int yn = 1;
    protected int yo = 10;
    protected b.a yp = new b.a() { // from class: com.baidu.adp.lib.b.a.1
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
        b bVar = new b(this.mName, this.ym, this.yp);
        bVar.a(this.yo, this.yl, this.yn);
        bVar.g(hq());
        d.hv().a(bVar);
    }

    public a() {
        initData();
        hr();
    }

    protected void initData() {
        this.mName = getName();
        this.yl = hm();
        this.ym = hn();
        this.yn = ho();
        this.yo = hp();
    }
}

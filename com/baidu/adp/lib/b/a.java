package com.baidu.adp.lib.b;

import com.baidu.adp.lib.b.b;
/* loaded from: classes.dex */
public abstract class a {
    protected String mName;
    protected String[] vI;
    protected int vJ = 0;
    protected int vK = 1;
    protected int vL = 10;
    protected b.a vM = new b.a() { // from class: com.baidu.adp.lib.b.a.1
        @Override // com.baidu.adp.lib.b.b.a
        public void a(String str, int i, boolean z) {
            a.this.aa(i);
        }
    };

    protected abstract void aa(int i);

    protected abstract String[] eY();

    protected abstract int eZ();

    protected abstract int fa();

    protected abstract int fb();

    protected abstract String getName();

    protected String[] fc() {
        return null;
    }

    protected void fd() {
        b bVar = new b(this.mName, this.vJ, this.vM);
        bVar.a(this.vL, this.vI, this.vK);
        bVar.g(fc());
        d.fh().a(bVar);
    }

    public a() {
        initData();
        fd();
    }

    protected void initData() {
        this.mName = getName();
        this.vI = eY();
        this.vJ = eZ();
        this.vK = fa();
        this.vL = fb();
    }
}

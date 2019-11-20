package com.baidu.adp.lib.b;

import com.baidu.adp.lib.b.b;
/* loaded from: classes.dex */
public abstract class a {
    protected String mName;
    protected String[] nF;
    protected int nG = 0;
    protected int nH = 1;
    protected int nI = 10;
    protected b.a nJ = new b.a() { // from class: com.baidu.adp.lib.b.a.1
        @Override // com.baidu.adp.lib.b.b.a
        public void a(String str, int i, boolean z) {
            a.this.C(i);
        }
    };

    protected abstract void C(int i);

    protected abstract String[] fi();

    protected abstract int fj();

    protected abstract int fk();

    protected abstract int fl();

    protected abstract String getName();

    /* JADX INFO: Access modifiers changed from: protected */
    public String[] fm() {
        return null;
    }

    protected void fn() {
        b bVar = new b(this.mName, this.nG, this.nJ);
        bVar.a(this.nI, this.nF, this.nH);
        bVar.g(fm());
        d.ft().a(bVar);
    }

    public a() {
        initData();
        fn();
    }

    protected void initData() {
        this.mName = getName();
        this.nF = fi();
        this.nG = fj();
        this.nH = fk();
        this.nI = fl();
    }
}

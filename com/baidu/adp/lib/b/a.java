package com.baidu.adp.lib.b;

import com.baidu.adp.lib.b.b;
/* loaded from: classes.dex */
public abstract class a {
    protected String mName;
    protected String[] oe;
    protected int of = 0;
    protected int og = 1;
    protected int oh = 10;
    protected b.a oi = new b.a() { // from class: com.baidu.adp.lib.b.a.1
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
        b bVar = new b(this.mName, this.of, this.oi);
        bVar.a(this.oh, this.oe, this.og);
        bVar.g(fm());
        d.ft().a(bVar);
    }

    public a() {
        initData();
        fn();
    }

    protected void initData() {
        this.mName = getName();
        this.oe = fi();
        this.of = fj();
        this.og = fk();
        this.oh = fl();
    }
}

package com.baidu.adp.lib.b;

import com.baidu.adp.lib.b.b;
/* loaded from: classes.dex */
public abstract class a {
    protected String mName;

    /* renamed from: tv  reason: collision with root package name */
    protected String[] f0tv;
    protected int tw = 0;
    protected int tz = 1;
    protected int tA = 10;
    protected b.a tB = new b.a() { // from class: com.baidu.adp.lib.b.a.1
        @Override // com.baidu.adp.lib.b.b.a
        public void a(String str, int i, boolean z) {
            a.this.W(i);
        }
    };

    protected abstract void W(int i);

    protected abstract String[] eM();

    protected abstract int eN();

    protected abstract int eO();

    protected abstract int eP();

    protected abstract String getName();

    protected String[] eQ() {
        return null;
    }

    protected void eR() {
        b bVar = new b(this.mName, this.tw, this.tB);
        bVar.a(this.tA, this.f0tv, this.tz);
        bVar.g(eQ());
        d.eV().a(bVar);
    }

    public a() {
        initData();
        eR();
    }

    protected void initData() {
        this.mName = getName();
        this.f0tv = eM();
        this.tw = eN();
        this.tz = eO();
        this.tA = eP();
    }
}

package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
class ad {
    int a;
    ae b;
    ae c;
    ae d;
    ae e;

    private ad() {
        this.a = 0;
        this.b = new ae(null);
        this.c = new ae(null);
        this.d = new ae(null);
        this.e = new ae(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ad(ad adVar) {
        this();
    }

    public int a() {
        return this.b.a + this.c.a + this.d.a + this.e.a;
    }

    public void b() {
        this.a = 0;
        this.b.a();
        this.c.a();
        this.d.a();
        this.e.a();
    }
}

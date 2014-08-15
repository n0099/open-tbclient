package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
class x {
    int a;
    boolean b;
    y c;
    y d;
    y e;
    y f;
    y g;

    private x() {
        this.a = 0;
        this.c = new y(null);
        this.d = new y(null);
        this.e = new y(null);
        this.f = new y(null);
        this.g = new y(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ x(x xVar) {
        this();
    }

    public int a() {
        return this.c.a + this.d.a + this.e.a + this.f.a + this.g.a;
    }

    public void b() {
        this.a = 0;
        this.c.a();
        this.d.a();
        this.e.a();
        this.f.a();
        this.g.a();
    }
}

package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
class af {
    int a;
    ag b;
    ag c;
    ag d;
    ag e;

    private af() {
        this.a = 0;
        this.b = new ag(null);
        this.c = new ag(null);
        this.d = new ag(null);
        this.e = new ag(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ af(af afVar) {
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

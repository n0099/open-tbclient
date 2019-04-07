package com.baidu.swan.pms.b.a.c;
/* loaded from: classes2.dex */
public class d {
    private static d bmx;
    private com.baidu.swan.pms.b.a.b.b bmy = new com.baidu.swan.pms.b.a.b.b();

    public static d RR() {
        if (bmx != null) {
            return bmx;
        }
        synchronized (d.class) {
            if (bmx == null) {
                bmx = new d();
            }
        }
        return bmx;
    }

    private d() {
    }

    public com.baidu.swan.pms.b.a.b f(f fVar) {
        if (fVar == null) {
            return null;
        }
        if (this.bmy.a(fVar, fVar.bmE)) {
            fVar.RS().G(fVar.RT());
            return new k(fVar, true);
        }
        return new k(fVar, false);
    }

    public synchronized <T> void g(f<T> fVar) {
        fVar.cS(false);
        this.bmy.b(fVar);
    }

    public synchronized void c(b bVar) {
        this.bmy.a(bVar);
    }

    public synchronized void d(b bVar) {
        this.bmy.b(bVar);
    }
}

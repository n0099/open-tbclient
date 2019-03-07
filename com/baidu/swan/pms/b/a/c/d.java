package com.baidu.swan.pms.b.a.c;
/* loaded from: classes2.dex */
public class d {
    private static d bmt;
    private com.baidu.swan.pms.b.a.b.b bmu = new com.baidu.swan.pms.b.a.b.b();

    public static d RT() {
        if (bmt != null) {
            return bmt;
        }
        synchronized (d.class) {
            if (bmt == null) {
                bmt = new d();
            }
        }
        return bmt;
    }

    private d() {
    }

    public com.baidu.swan.pms.b.a.b f(f fVar) {
        if (fVar == null) {
            return null;
        }
        if (this.bmu.a(fVar, fVar.bmA)) {
            fVar.RU().G(fVar.RV());
            return new k(fVar, true);
        }
        return new k(fVar, false);
    }

    public synchronized <T> void g(f<T> fVar) {
        fVar.cS(false);
        this.bmu.b(fVar);
    }

    public synchronized void c(b bVar) {
        this.bmu.a(bVar);
    }

    public synchronized void d(b bVar) {
        this.bmu.b(bVar);
    }
}

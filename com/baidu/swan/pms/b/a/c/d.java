package com.baidu.swan.pms.b.a.c;
/* loaded from: classes2.dex */
public class d {
    private static d bmu;
    private com.baidu.swan.pms.b.a.b.b bmv = new com.baidu.swan.pms.b.a.b.b();

    public static d RT() {
        if (bmu != null) {
            return bmu;
        }
        synchronized (d.class) {
            if (bmu == null) {
                bmu = new d();
            }
        }
        return bmu;
    }

    private d() {
    }

    public com.baidu.swan.pms.b.a.b f(f fVar) {
        if (fVar == null) {
            return null;
        }
        if (this.bmv.a(fVar, fVar.bmB)) {
            fVar.RU().G(fVar.RV());
            return new k(fVar, true);
        }
        return new k(fVar, false);
    }

    public synchronized <T> void g(f<T> fVar) {
        fVar.cS(false);
        this.bmv.b(fVar);
    }

    public synchronized void c(b bVar) {
        this.bmv.a(bVar);
    }

    public synchronized void d(b bVar) {
        this.bmv.b(bVar);
    }
}

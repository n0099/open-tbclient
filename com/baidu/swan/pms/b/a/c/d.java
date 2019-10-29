package com.baidu.swan.pms.b.a.c;
/* loaded from: classes2.dex */
public class d {
    private static d bMy;
    private com.baidu.swan.pms.b.a.b.b bMz = new com.baidu.swan.pms.b.a.b.b();

    public static d abr() {
        if (bMy != null) {
            return bMy;
        }
        synchronized (d.class) {
            if (bMy == null) {
                bMy = new d();
            }
        }
        return bMy;
    }

    private d() {
    }

    public com.baidu.swan.pms.b.a.b f(f fVar) {
        if (fVar == null) {
            return null;
        }
        if (this.bMz.a(fVar, fVar.bME)) {
            fVar.abs().E(fVar.abt());
            return new k(fVar, true);
        }
        return new k(fVar, false);
    }

    public synchronized <T> void g(f<T> fVar) {
        fVar.dF(false);
        this.bMz.b(fVar);
    }

    public synchronized void c(b bVar) {
        this.bMz.a(bVar);
    }

    public synchronized void d(b bVar) {
        this.bMz.b(bVar);
    }
}

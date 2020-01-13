package com.baidu.swan.pms.c.a.d;
/* loaded from: classes10.dex */
public class d {
    private static d cxz;
    private com.baidu.swan.pms.c.a.c.b cxA = new com.baidu.swan.pms.c.a.c.b();

    public static d arF() {
        if (cxz != null) {
            return cxz;
        }
        synchronized (d.class) {
            if (cxz == null) {
                cxz = new d();
            }
        }
        return cxz;
    }

    private d() {
    }

    public com.baidu.swan.pms.c.a.b i(f fVar) {
        if (fVar == null) {
            return null;
        }
        return new k(fVar, false);
    }

    public synchronized <T> void j(f<T> fVar) {
        fVar.eT(false);
        this.cxA.b(fVar);
    }

    public synchronized void c(b bVar) {
        this.cxA.a(bVar);
    }

    public synchronized void d(b bVar) {
        this.cxA.b(bVar);
    }
}

package com.baidu.swan.pms.c.a.d;
/* loaded from: classes9.dex */
public class d {
    private static d cxo;
    private com.baidu.swan.pms.c.a.c.b cxp = new com.baidu.swan.pms.c.a.c.b();

    public static d arm() {
        if (cxo != null) {
            return cxo;
        }
        synchronized (d.class) {
            if (cxo == null) {
                cxo = new d();
            }
        }
        return cxo;
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
        fVar.eO(false);
        this.cxp.b(fVar);
    }

    public synchronized void c(b bVar) {
        this.cxp.a(bVar);
    }

    public synchronized void d(b bVar) {
        this.cxp.b(bVar);
    }
}

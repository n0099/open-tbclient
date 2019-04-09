package com.baidu.swan.pms.b.a.c;
/* loaded from: classes2.dex */
public class d {
    private static d bmy;
    private com.baidu.swan.pms.b.a.b.b bmz = new com.baidu.swan.pms.b.a.b.b();

    public static d RR() {
        if (bmy != null) {
            return bmy;
        }
        synchronized (d.class) {
            if (bmy == null) {
                bmy = new d();
            }
        }
        return bmy;
    }

    private d() {
    }

    public com.baidu.swan.pms.b.a.b f(f fVar) {
        if (fVar == null) {
            return null;
        }
        if (this.bmz.a(fVar, fVar.bmF)) {
            fVar.RS().G(fVar.RT());
            return new k(fVar, true);
        }
        return new k(fVar, false);
    }

    public synchronized <T> void g(f<T> fVar) {
        fVar.cS(false);
        this.bmz.b(fVar);
    }

    public synchronized void c(b bVar) {
        this.bmz.a(bVar);
    }

    public synchronized void d(b bVar) {
        this.bmz.b(bVar);
    }
}

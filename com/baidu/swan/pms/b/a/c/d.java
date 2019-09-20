package com.baidu.swan.pms.b.a.c;
/* loaded from: classes2.dex */
public class d {
    private static d btN;
    private com.baidu.swan.pms.b.a.b.b btO = new com.baidu.swan.pms.b.a.b.b();

    public static d WC() {
        if (btN != null) {
            return btN;
        }
        synchronized (d.class) {
            if (btN == null) {
                btN = new d();
            }
        }
        return btN;
    }

    private d() {
    }

    public com.baidu.swan.pms.b.a.b f(f fVar) {
        if (fVar == null) {
            return null;
        }
        if (this.btO.a(fVar, fVar.btT)) {
            fVar.WD().G(fVar.WE());
            return new k(fVar, true);
        }
        return new k(fVar, false);
    }

    public synchronized <T> void g(f<T> fVar) {
        fVar.m17do(false);
        this.btO.b(fVar);
    }

    public synchronized void c(b bVar) {
        this.btO.a(bVar);
    }

    public synchronized void d(b bVar) {
        this.btO.b(bVar);
    }
}

package com.baidu.swan.pms.b.a.c;
/* loaded from: classes2.dex */
public class d {
    private static d btp;
    private com.baidu.swan.pms.b.a.b.b btq = new com.baidu.swan.pms.b.a.b.b();

    public static d Wy() {
        if (btp != null) {
            return btp;
        }
        synchronized (d.class) {
            if (btp == null) {
                btp = new d();
            }
        }
        return btp;
    }

    private d() {
    }

    public com.baidu.swan.pms.b.a.b f(f fVar) {
        if (fVar == null) {
            return null;
        }
        if (this.btq.a(fVar, fVar.btv)) {
            fVar.Wz().G(fVar.WA());
            return new k(fVar, true);
        }
        return new k(fVar, false);
    }

    public synchronized <T> void g(f<T> fVar) {
        fVar.m17do(false);
        this.btq.b(fVar);
    }

    public synchronized void c(b bVar) {
        this.btq.a(bVar);
    }

    public synchronized void d(b bVar) {
        this.btq.b(bVar);
    }
}

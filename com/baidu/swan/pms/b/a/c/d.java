package com.baidu.swan.pms.b.a.c;
/* loaded from: classes2.dex */
public class d {
    private static d bsz;
    private com.baidu.swan.pms.b.a.b.b bsA = new com.baidu.swan.pms.b.a.b.b();

    public static d VF() {
        if (bsz != null) {
            return bsz;
        }
        synchronized (d.class) {
            if (bsz == null) {
                bsz = new d();
            }
        }
        return bsz;
    }

    private d() {
    }

    public com.baidu.swan.pms.b.a.b f(f fVar) {
        if (fVar == null) {
            return null;
        }
        if (this.bsA.a(fVar, fVar.bsF)) {
            fVar.VG().G(fVar.VH());
            return new k(fVar, true);
        }
        return new k(fVar, false);
    }

    public synchronized <T> void g(f<T> fVar) {
        fVar.dj(false);
        this.bsA.b(fVar);
    }

    public synchronized void c(b bVar) {
        this.bsA.a(bVar);
    }

    public synchronized void d(b bVar) {
        this.bsA.b(bVar);
    }
}

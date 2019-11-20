package com.baidu.swan.pms.b.a.c;
/* loaded from: classes2.dex */
public class d {
    private static d bLH;
    private com.baidu.swan.pms.b.a.b.b bLI = new com.baidu.swan.pms.b.a.b.b();

    public static d abp() {
        if (bLH != null) {
            return bLH;
        }
        synchronized (d.class) {
            if (bLH == null) {
                bLH = new d();
            }
        }
        return bLH;
    }

    private d() {
    }

    public com.baidu.swan.pms.b.a.b f(f fVar) {
        if (fVar == null) {
            return null;
        }
        if (this.bLI.a(fVar, fVar.bLN)) {
            fVar.abq().E(fVar.abr());
            return new k(fVar, true);
        }
        return new k(fVar, false);
    }

    public synchronized <T> void g(f<T> fVar) {
        fVar.dF(false);
        this.bLI.b(fVar);
    }

    public synchronized void c(b bVar) {
        this.bLI.a(bVar);
    }

    public synchronized void d(b bVar) {
        this.bLI.b(bVar);
    }
}

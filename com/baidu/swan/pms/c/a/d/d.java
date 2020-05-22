package com.baidu.swan.pms.c.a.d;
/* loaded from: classes11.dex */
public class d {
    private static d dma;
    private com.baidu.swan.pms.c.a.c.b dmb = new com.baidu.swan.pms.c.a.c.b();

    public static d aGy() {
        if (dma != null) {
            return dma;
        }
        synchronized (d.class) {
            if (dma == null) {
                dma = new d();
            }
        }
        return dma;
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
        fVar.gj(false);
        this.dmb.b(fVar);
    }

    public synchronized boolean td(String str) {
        return this.dmb.td(str);
    }

    public synchronized boolean te(String str) {
        return this.dmb.te(str);
    }

    public synchronized void c(b bVar) {
        this.dmb.a(bVar);
    }

    public synchronized void d(b bVar) {
        this.dmb.b(bVar);
    }
}

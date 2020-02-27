package com.baidu.swan.pms.c.a.d;
/* loaded from: classes11.dex */
public class d {
    private static d cBx;
    private com.baidu.swan.pms.c.a.c.b cBy = new com.baidu.swan.pms.c.a.c.b();

    public static d atT() {
        if (cBx != null) {
            return cBx;
        }
        synchronized (d.class) {
            if (cBx == null) {
                cBx = new d();
            }
        }
        return cBx;
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
        fVar.fa(false);
        this.cBy.b(fVar);
    }

    public synchronized void c(b bVar) {
        this.cBy.a(bVar);
    }

    public synchronized void d(b bVar) {
        this.cBy.b(bVar);
    }
}

package com.baidu.swan.pms.c.a.d;
/* loaded from: classes11.dex */
public class d {
    private static d cBy;
    private com.baidu.swan.pms.c.a.c.b cBz = new com.baidu.swan.pms.c.a.c.b();

    public static d atV() {
        if (cBy != null) {
            return cBy;
        }
        synchronized (d.class) {
            if (cBy == null) {
                cBy = new d();
            }
        }
        return cBy;
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
        this.cBz.b(fVar);
    }

    public synchronized void c(b bVar) {
        this.cBz.a(bVar);
    }

    public synchronized void d(b bVar) {
        this.cBz.b(bVar);
    }
}

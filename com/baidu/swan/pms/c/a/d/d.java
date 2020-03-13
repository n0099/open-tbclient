package com.baidu.swan.pms.c.a.d;
/* loaded from: classes11.dex */
public class d {
    private static d cBz;
    private com.baidu.swan.pms.c.a.c.b cBA = new com.baidu.swan.pms.c.a.c.b();

    public static d atV() {
        if (cBz != null) {
            return cBz;
        }
        synchronized (d.class) {
            if (cBz == null) {
                cBz = new d();
            }
        }
        return cBz;
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
        this.cBA.b(fVar);
    }

    public synchronized void c(b bVar) {
        this.cBA.a(bVar);
    }

    public synchronized void d(b bVar) {
        this.cBA.b(bVar);
    }
}

package com.baidu.swan.pms.c.a.d;
/* loaded from: classes11.dex */
public class d {
    private static d daP;
    private com.baidu.swan.pms.c.a.c.b daQ = new com.baidu.swan.pms.c.a.c.b();

    public static d aCi() {
        if (daP != null) {
            return daP;
        }
        synchronized (d.class) {
            if (daP == null) {
                daP = new d();
            }
        }
        return daP;
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
        fVar.fY(false);
        this.daQ.b(fVar);
    }

    public synchronized void c(b bVar) {
        this.daQ.a(bVar);
    }

    public synchronized void d(b bVar) {
        this.daQ.b(bVar);
    }
}

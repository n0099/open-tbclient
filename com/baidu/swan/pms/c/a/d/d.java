package com.baidu.swan.pms.c.a.d;
/* loaded from: classes11.dex */
public class d {
    private static d daK;
    private com.baidu.swan.pms.c.a.c.b daL = new com.baidu.swan.pms.c.a.c.b();

    public static d aCi() {
        if (daK != null) {
            return daK;
        }
        synchronized (d.class) {
            if (daK == null) {
                daK = new d();
            }
        }
        return daK;
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
        this.daL.b(fVar);
    }

    public synchronized void c(b bVar) {
        this.daL.a(bVar);
    }

    public synchronized void d(b bVar) {
        this.daL.b(bVar);
    }
}

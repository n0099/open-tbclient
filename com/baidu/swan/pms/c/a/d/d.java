package com.baidu.swan.pms.c.a.d;
/* loaded from: classes6.dex */
public class d {
    private static d exf;
    private com.baidu.swan.pms.c.a.c.b exg = new com.baidu.swan.pms.c.a.c.b();

    public static d bgC() {
        if (exf != null) {
            return exf;
        }
        synchronized (d.class) {
            if (exf == null) {
                exf = new d();
            }
        }
        return exf;
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
        fVar.iG(false);
        this.exg.b(fVar);
    }

    public synchronized boolean yK(String str) {
        return this.exg.yK(str);
    }

    public synchronized boolean yL(String str) {
        return this.exg.yL(str);
    }

    public synchronized void c(b bVar) {
        this.exg.a(bVar);
    }

    public synchronized void d(b bVar) {
        this.exg.b(bVar);
    }
}

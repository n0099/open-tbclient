package com.baidu.swan.pms.c.a.d;
/* loaded from: classes6.dex */
public class d {
    private static d ess;
    private com.baidu.swan.pms.c.a.c.b est = new com.baidu.swan.pms.c.a.c.b();

    public static d bcJ() {
        if (ess != null) {
            return ess;
        }
        synchronized (d.class) {
            if (ess == null) {
                ess = new d();
            }
        }
        return ess;
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
        fVar.iC(false);
        this.est.b(fVar);
    }

    public synchronized boolean xz(String str) {
        return this.est.xz(str);
    }

    public synchronized boolean xA(String str) {
        return this.est.xA(str);
    }

    public synchronized void c(b bVar) {
        this.est.a(bVar);
    }

    public synchronized void d(b bVar) {
        this.est.b(bVar);
    }
}

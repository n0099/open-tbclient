package com.baidu.swan.pms.c.a.d;
/* loaded from: classes15.dex */
public class d {
    private static d dTP;
    private com.baidu.swan.pms.c.a.c.b dTQ = new com.baidu.swan.pms.c.a.c.b();

    public static d aXp() {
        if (dTP != null) {
            return dTP;
        }
        synchronized (d.class) {
            if (dTP == null) {
                dTP = new d();
            }
        }
        return dTP;
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
        fVar.hy(false);
        this.dTQ.b(fVar);
    }

    public synchronized boolean xC(String str) {
        return this.dTQ.xC(str);
    }

    public synchronized boolean xD(String str) {
        return this.dTQ.xD(str);
    }

    public synchronized void c(b bVar) {
        this.dTQ.a(bVar);
    }

    public synchronized void d(b bVar) {
        this.dTQ.b(bVar);
    }
}

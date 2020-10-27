package com.baidu.swan.pms.c.a.d;
/* loaded from: classes15.dex */
public class d {
    private static d ecl;
    private com.baidu.swan.pms.c.a.c.b ecm = new com.baidu.swan.pms.c.a.c.b();

    public static d aZi() {
        if (ecl != null) {
            return ecl;
        }
        synchronized (d.class) {
            if (ecl == null) {
                ecl = new d();
            }
        }
        return ecl;
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
        fVar.hL(false);
        this.ecm.b(fVar);
    }

    public synchronized boolean xV(String str) {
        return this.ecm.xV(str);
    }

    public synchronized boolean xW(String str) {
        return this.ecm.xW(str);
    }

    public synchronized void c(b bVar) {
        this.ecm.a(bVar);
    }

    public synchronized void d(b bVar) {
        this.ecm.b(bVar);
    }
}

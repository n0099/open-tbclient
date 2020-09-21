package com.baidu.swan.pms.c.a.d;
/* loaded from: classes24.dex */
public class d {
    private static d dHO;
    private com.baidu.swan.pms.c.a.c.b dHP = new com.baidu.swan.pms.c.a.c.b();

    public static d aUG() {
        if (dHO != null) {
            return dHO;
        }
        synchronized (d.class) {
            if (dHO == null) {
                dHO = new d();
            }
        }
        return dHO;
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
        fVar.hc(false);
        this.dHP.b(fVar);
    }

    public synchronized boolean wQ(String str) {
        return this.dHP.wQ(str);
    }

    public synchronized boolean wR(String str) {
        return this.dHP.wR(str);
    }

    public synchronized void c(b bVar) {
        this.dHP.a(bVar);
    }

    public synchronized void d(b bVar) {
        this.dHP.b(bVar);
    }
}

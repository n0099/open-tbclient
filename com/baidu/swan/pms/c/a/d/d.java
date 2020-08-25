package com.baidu.swan.pms.c.a.d;
/* loaded from: classes14.dex */
public class d {
    private static d dFG;
    private com.baidu.swan.pms.c.a.c.b dFH = new com.baidu.swan.pms.c.a.c.b();

    public static d aTU() {
        if (dFG != null) {
            return dFG;
        }
        synchronized (d.class) {
            if (dFG == null) {
                dFG = new d();
            }
        }
        return dFG;
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
        fVar.hd(false);
        this.dFH.b(fVar);
    }

    public synchronized boolean ww(String str) {
        return this.dFH.ww(str);
    }

    public synchronized boolean wx(String str) {
        return this.dFH.wx(str);
    }

    public synchronized void c(b bVar) {
        this.dFH.a(bVar);
    }

    public synchronized void d(b bVar) {
        this.dFH.b(bVar);
    }
}

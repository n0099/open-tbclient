package com.baidu.swan.pms.c.a.d;
/* loaded from: classes14.dex */
public class d {
    private static d dFK;
    private com.baidu.swan.pms.c.a.c.b dFL = new com.baidu.swan.pms.c.a.c.b();

    public static d aTU() {
        if (dFK != null) {
            return dFK;
        }
        synchronized (d.class) {
            if (dFK == null) {
                dFK = new d();
            }
        }
        return dFK;
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
        fVar.he(false);
        this.dFL.b(fVar);
    }

    public synchronized boolean wx(String str) {
        return this.dFL.wx(str);
    }

    public synchronized boolean wy(String str) {
        return this.dFL.wy(str);
    }

    public synchronized void c(b bVar) {
        this.dFL.a(bVar);
    }

    public synchronized void d(b bVar) {
        this.dFL.b(bVar);
    }
}

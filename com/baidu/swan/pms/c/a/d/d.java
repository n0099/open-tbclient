package com.baidu.swan.pms.c.a.d;
/* loaded from: classes19.dex */
public class d {
    private static d dwD;
    private com.baidu.swan.pms.c.a.c.b dwE = new com.baidu.swan.pms.c.a.c.b();

    public static d aLv() {
        if (dwD != null) {
            return dwD;
        }
        synchronized (d.class) {
            if (dwD == null) {
                dwD = new d();
            }
        }
        return dwD;
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
        fVar.gJ(false);
        this.dwE.b(fVar);
    }

    public synchronized boolean uo(String str) {
        return this.dwE.uo(str);
    }

    public synchronized boolean up(String str) {
        return this.dwE.up(str);
    }

    public synchronized void c(b bVar) {
        this.dwE.a(bVar);
    }

    public synchronized void d(b bVar) {
        this.dwE.b(bVar);
    }
}

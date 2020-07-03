package com.baidu.swan.pms.c.a.d;
/* loaded from: classes11.dex */
public class d {
    private static d dqL;
    private com.baidu.swan.pms.c.a.c.b dqM = new com.baidu.swan.pms.c.a.c.b();

    public static d aHE() {
        if (dqL != null) {
            return dqL;
        }
        synchronized (d.class) {
            if (dqL == null) {
                dqL = new d();
            }
        }
        return dqL;
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
        fVar.go(false);
        this.dqM.b(fVar);
    }

    public synchronized boolean tl(String str) {
        return this.dqM.tl(str);
    }

    public synchronized boolean tm(String str) {
        return this.dqM.tm(str);
    }

    public synchronized void c(b bVar) {
        this.dqM.a(bVar);
    }

    public synchronized void d(b bVar) {
        this.dqM.b(bVar);
    }
}

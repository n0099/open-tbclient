package com.baidu.swan.pms.c.a.d;
/* loaded from: classes6.dex */
public class d {
    private static d eny;
    private com.baidu.swan.pms.c.a.c.b enz = new com.baidu.swan.pms.c.a.c.b();

    public static d beg() {
        if (eny != null) {
            return eny;
        }
        synchronized (d.class) {
            if (eny == null) {
                eny = new d();
            }
        }
        return eny;
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
        fVar.im(false);
        this.enz.b(fVar);
    }

    public synchronized boolean yL(String str) {
        return this.enz.yL(str);
    }

    public synchronized boolean yM(String str) {
        return this.enz.yM(str);
    }

    public synchronized void c(b bVar) {
        this.enz.a(bVar);
    }

    public synchronized void d(b bVar) {
        this.enz.b(bVar);
    }
}

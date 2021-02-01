package com.baidu.swan.pms.c.a.d;
/* loaded from: classes3.dex */
public class d {
    private static d euz;
    private com.baidu.swan.pms.c.a.c.b euA = new com.baidu.swan.pms.c.a.c.b();

    public static d bcW() {
        if (euz != null) {
            return euz;
        }
        synchronized (d.class) {
            if (euz == null) {
                euz = new d();
            }
        }
        return euz;
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
        fVar.iE(false);
        this.euA.b(fVar);
    }

    public synchronized boolean xS(String str) {
        return this.euA.xS(str);
    }

    public synchronized boolean xT(String str) {
        return this.euA.xT(str);
    }

    public synchronized void c(b bVar) {
        this.euA.a(bVar);
    }

    public synchronized void d(b bVar) {
        this.euA.b(bVar);
    }
}

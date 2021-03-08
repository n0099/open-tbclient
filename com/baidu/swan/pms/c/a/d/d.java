package com.baidu.swan.pms.c.a.d;
/* loaded from: classes3.dex */
public class d {
    private static d ewa;
    private com.baidu.swan.pms.c.a.c.b ewb = new com.baidu.swan.pms.c.a.c.b();

    public static d bcY() {
        if (ewa != null) {
            return ewa;
        }
        synchronized (d.class) {
            if (ewa == null) {
                ewa = new d();
            }
        }
        return ewa;
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
        this.ewb.b(fVar);
    }

    public synchronized boolean xZ(String str) {
        return this.ewb.xZ(str);
    }

    public synchronized boolean ya(String str) {
        return this.ewb.ya(str);
    }

    public synchronized void c(b bVar) {
        this.ewb.a(bVar);
    }

    public synchronized void d(b bVar) {
        this.ewb.b(bVar);
    }
}

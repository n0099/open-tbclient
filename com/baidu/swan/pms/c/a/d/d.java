package com.baidu.swan.pms.c.a.d;
/* loaded from: classes15.dex */
public class d {
    private static d eid;
    private com.baidu.swan.pms.c.a.c.b eie = new com.baidu.swan.pms.c.a.c.b();

    public static d bbI() {
        if (eid != null) {
            return eid;
        }
        synchronized (d.class) {
            if (eid == null) {
                eid = new d();
            }
        }
        return eid;
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
        fVar.hU(false);
        this.eie.b(fVar);
    }

    public synchronized boolean yj(String str) {
        return this.eie.yj(str);
    }

    public synchronized boolean yk(String str) {
        return this.eie.yk(str);
    }

    public synchronized void c(b bVar) {
        this.eie.a(bVar);
    }

    public synchronized void d(b bVar) {
        this.eie.b(bVar);
    }
}

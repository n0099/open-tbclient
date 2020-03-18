package com.baidu.swan.pms.c.a.d;
/* loaded from: classes11.dex */
public class d {
    private static d cBK;
    private com.baidu.swan.pms.c.a.c.b cBL = new com.baidu.swan.pms.c.a.c.b();

    public static d atY() {
        if (cBK != null) {
            return cBK;
        }
        synchronized (d.class) {
            if (cBK == null) {
                cBK = new d();
            }
        }
        return cBK;
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
        fVar.fb(false);
        this.cBL.b(fVar);
    }

    public synchronized void c(b bVar) {
        this.cBL.a(bVar);
    }

    public synchronized void d(b bVar) {
        this.cBL.b(bVar);
    }
}

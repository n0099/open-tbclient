package com.baidu.swan.pms.c.a.d;
/* loaded from: classes6.dex */
public class d {
    private static d egw;
    private com.baidu.swan.pms.c.a.c.b egx = new com.baidu.swan.pms.c.a.c.b();

    public static d bbb() {
        if (egw != null) {
            return egw;
        }
        synchronized (d.class) {
            if (egw == null) {
                egw = new d();
            }
        }
        return egw;
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
        fVar.hX(false);
        this.egx.b(fVar);
    }

    public synchronized boolean ye(String str) {
        return this.egx.ye(str);
    }

    public synchronized boolean yf(String str) {
        return this.egx.yf(str);
    }

    public synchronized void c(b bVar) {
        this.egx.a(bVar);
    }

    public synchronized void d(b bVar) {
        this.egx.b(bVar);
    }
}

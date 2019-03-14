package com.baidu.platform.comapi.wnplatform.m;
/* loaded from: classes5.dex */
public class d {
    private static final String a = d.class.getSimpleName();
    private static d b;
    private boolean c = false;

    public static synchronized d a() {
        d dVar;
        synchronized (d.class) {
            if (b == null) {
                b = new d();
            }
            dVar = b;
        }
        return dVar;
    }

    private d() {
    }

    public synchronized void a(boolean z) {
        com.baidu.platform.comapi.wnplatform.d.a.b(a + "setBusy:" + z);
        this.c = z;
    }
}

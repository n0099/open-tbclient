package com.baidu.platform.comapi.wnplatform.n;
/* loaded from: classes26.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static final String f3138a = d.class.getSimpleName();
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
        com.baidu.platform.comapi.wnplatform.d.a.b(f3138a + "setBusy:" + z);
        this.c = z;
    }
}

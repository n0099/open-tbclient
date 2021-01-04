package com.baidu.platform.comapi.wnplatform.n;
/* loaded from: classes15.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static final String f4671a = d.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private static d f4672b;
    private boolean c = false;

    public static synchronized d a() {
        d dVar;
        synchronized (d.class) {
            if (f4672b == null) {
                f4672b = new d();
            }
            dVar = f4672b;
        }
        return dVar;
    }

    private d() {
    }

    public synchronized void a(boolean z) {
        com.baidu.platform.comapi.wnplatform.d.a.b(f4671a + "setBusy:" + z);
        this.c = z;
    }
}

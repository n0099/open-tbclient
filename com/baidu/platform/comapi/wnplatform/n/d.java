package com.baidu.platform.comapi.wnplatform.n;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static final String f4672a = d.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private static d f4673b;
    private boolean c = false;

    public static synchronized d a() {
        d dVar;
        synchronized (d.class) {
            if (f4673b == null) {
                f4673b = new d();
            }
            dVar = f4673b;
        }
        return dVar;
    }

    private d() {
    }

    public synchronized void a(boolean z) {
        com.baidu.platform.comapi.wnplatform.d.a.b(f4672a + "setBusy:" + z);
        this.c = z;
    }
}

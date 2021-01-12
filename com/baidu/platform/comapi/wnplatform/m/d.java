package com.baidu.platform.comapi.wnplatform.m;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static final String f4430a = d.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private static d f4431b;
    private boolean c = false;

    public static synchronized d a() {
        d dVar;
        synchronized (d.class) {
            if (f4431b == null) {
                f4431b = new d();
            }
            dVar = f4431b;
        }
        return dVar;
    }

    private d() {
    }

    public synchronized void a(boolean z) {
        com.baidu.platform.comapi.wnplatform.d.a.b(f4430a + "setBusy:" + z);
        this.c = z;
    }
}

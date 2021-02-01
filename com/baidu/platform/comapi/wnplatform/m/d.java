package com.baidu.platform.comapi.wnplatform.m;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static final String f4433a = d.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private static d f4434b;
    private boolean c = false;

    public static synchronized d a() {
        d dVar;
        synchronized (d.class) {
            if (f4434b == null) {
                f4434b = new d();
            }
            dVar = f4434b;
        }
        return dVar;
    }

    private d() {
    }

    public synchronized void a(boolean z) {
        com.baidu.platform.comapi.wnplatform.d.a.b(f4433a + "setBusy:" + z);
        this.c = z;
    }
}

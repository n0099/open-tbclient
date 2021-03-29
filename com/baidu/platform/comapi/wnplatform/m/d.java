package com.baidu.platform.comapi.wnplatform.m;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final String f10314a = "d";

    /* renamed from: b  reason: collision with root package name */
    public static d f10315b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f10316c = false;

    public static synchronized d a() {
        d dVar;
        synchronized (d.class) {
            if (f10315b == null) {
                f10315b = new d();
            }
            dVar = f10315b;
        }
        return dVar;
    }

    public synchronized void a(boolean z) {
        com.baidu.platform.comapi.wnplatform.d.a.b(f10314a + "setBusy:" + z);
        this.f10316c = z;
    }
}

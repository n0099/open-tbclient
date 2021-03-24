package com.baidu.platform.comapi.wnplatform.m;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final String f10313a = "d";

    /* renamed from: b  reason: collision with root package name */
    public static d f10314b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f10315c = false;

    public static synchronized d a() {
        d dVar;
        synchronized (d.class) {
            if (f10314b == null) {
                f10314b = new d();
            }
            dVar = f10314b;
        }
        return dVar;
    }

    public synchronized void a(boolean z) {
        com.baidu.platform.comapi.wnplatform.d.a.b(f10313a + "setBusy:" + z);
        this.f10315c = z;
    }
}

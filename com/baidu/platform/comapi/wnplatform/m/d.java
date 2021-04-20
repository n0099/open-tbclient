package com.baidu.platform.comapi.wnplatform.m;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final String f9872a = "d";

    /* renamed from: b  reason: collision with root package name */
    public static d f9873b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f9874c = false;

    public static synchronized d a() {
        d dVar;
        synchronized (d.class) {
            if (f9873b == null) {
                f9873b = new d();
            }
            dVar = f9873b;
        }
        return dVar;
    }

    public synchronized void a(boolean z) {
        com.baidu.platform.comapi.wnplatform.d.a.b(f9872a + "setBusy:" + z);
        this.f9874c = z;
    }
}

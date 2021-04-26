package com.baidu.platform.comapi.wnplatform.m;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final String f10239a = "d";

    /* renamed from: b  reason: collision with root package name */
    public static d f10240b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f10241c = false;

    public static synchronized d a() {
        d dVar;
        synchronized (d.class) {
            if (f10240b == null) {
                f10240b = new d();
            }
            dVar = f10240b;
        }
        return dVar;
    }

    public synchronized void a(boolean z) {
        com.baidu.platform.comapi.wnplatform.d.a.b(f10239a + "setBusy:" + z);
        this.f10241c = z;
    }
}

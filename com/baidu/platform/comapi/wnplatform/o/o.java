package com.baidu.platform.comapi.wnplatform.o;
/* loaded from: classes4.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    private static o f4469a;

    /* renamed from: b  reason: collision with root package name */
    private String f4470b;
    private String c;

    public static synchronized o a() {
        o oVar;
        synchronized (o.class) {
            if (f4469a == null) {
                f4469a = new o();
            }
            oVar = f4469a;
        }
        return oVar;
    }

    private o() {
    }

    public void b() {
        this.c = "";
        this.f4470b = "";
    }
}

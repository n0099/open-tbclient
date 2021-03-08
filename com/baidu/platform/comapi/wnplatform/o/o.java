package com.baidu.platform.comapi.wnplatform.o;
/* loaded from: classes4.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    private static o f3090a;
    private String b;
    private String c;

    public static synchronized o a() {
        o oVar;
        synchronized (o.class) {
            if (f3090a == null) {
                f3090a = new o();
            }
            oVar = f3090a;
        }
        return oVar;
    }

    private o() {
    }

    public void b() {
        this.c = "";
        this.b = "";
    }
}

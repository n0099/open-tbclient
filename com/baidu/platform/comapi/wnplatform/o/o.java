package com.baidu.platform.comapi.wnplatform.o;
/* loaded from: classes6.dex */
public class o {
    private static o a;
    private String b;
    private String c;

    public static synchronized o a() {
        o oVar;
        synchronized (o.class) {
            if (a == null) {
                a = new o();
            }
            oVar = a;
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

package com.baidu.platform.comapi.wnplatform.p;
/* loaded from: classes20.dex */
public class p {
    private static p a;
    private String b;
    private String c;

    public static synchronized p a() {
        p pVar;
        synchronized (p.class) {
            if (a == null) {
                a = new p();
            }
            pVar = a;
        }
        return pVar;
    }

    private p() {
    }

    public void b() {
        this.c = "";
        this.b = "";
    }
}

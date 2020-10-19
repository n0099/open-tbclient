package com.baidu.platform.comapi.wnplatform.p;
/* loaded from: classes7.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    private static p f3153a;
    private String b;
    private String c;

    public static synchronized p a() {
        p pVar;
        synchronized (p.class) {
            if (f3153a == null) {
                f3153a = new p();
            }
            pVar = f3153a;
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

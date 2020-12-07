package com.baidu.platform.comapi.wnplatform.p;
/* loaded from: classes26.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    private static p f3157a;
    private String b;
    private String c;

    public static synchronized p a() {
        p pVar;
        synchronized (p.class) {
            if (f3157a == null) {
                f3157a = new p();
            }
            pVar = f3157a;
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

package com.baidu.platform.comapi.wnplatform.p;
/* loaded from: classes3.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    private static p f4703a;

    /* renamed from: b  reason: collision with root package name */
    private String f4704b;
    private String c;

    public static synchronized p a() {
        p pVar;
        synchronized (p.class) {
            if (f4703a == null) {
                f4703a = new p();
            }
            pVar = f4703a;
        }
        return pVar;
    }

    private p() {
    }

    public void b() {
        this.c = "";
        this.f4704b = "";
    }
}

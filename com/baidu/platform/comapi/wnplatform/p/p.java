package com.baidu.platform.comapi.wnplatform.p;
/* loaded from: classes15.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    private static p f4702a;

    /* renamed from: b  reason: collision with root package name */
    private String f4703b;
    private String c;

    public static synchronized p a() {
        p pVar;
        synchronized (p.class) {
            if (f4702a == null) {
                f4702a = new p();
            }
            pVar = f4702a;
        }
        return pVar;
    }

    private p() {
    }

    public void b() {
        this.c = "";
        this.f4703b = "";
    }
}

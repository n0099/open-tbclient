package com.baidu.platform.comapi.wnplatform.f;
/* loaded from: classes3.dex */
public class a {
    private static a a;
    private String b;
    private String c;

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (a == null) {
                a = new a();
            }
            aVar = a;
        }
        return aVar;
    }

    private a() {
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }
}

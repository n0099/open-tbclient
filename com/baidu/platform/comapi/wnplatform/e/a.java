package com.baidu.platform.comapi.wnplatform.e;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f3051a;
    private String b;
    private String c;

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (f3051a == null) {
                f3051a = new a();
            }
            aVar = f3051a;
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

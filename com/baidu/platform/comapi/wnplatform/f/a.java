package com.baidu.platform.comapi.wnplatform.f;
/* loaded from: classes26.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f3115a;
    private String b;
    private String c;

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (f3115a == null) {
                f3115a = new a();
            }
            aVar = f3115a;
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

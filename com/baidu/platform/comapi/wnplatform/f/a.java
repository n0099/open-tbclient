package com.baidu.platform.comapi.wnplatform.f;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f3111a;
    private String b;
    private String c;

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (f3111a == null) {
                f3111a = new a();
            }
            aVar = f3111a;
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

package com.baidu.platform.comapi.wnplatform.f;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f3113a;
    private String b;
    private String c;

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (f3113a == null) {
                f3113a = new a();
            }
            aVar = f3113a;
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

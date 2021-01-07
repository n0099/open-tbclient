package com.baidu.platform.comapi.wnplatform.f;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f4633a;

    /* renamed from: b  reason: collision with root package name */
    private String f4634b;
    private String c;

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (f4633a == null) {
                f4633a = new a();
            }
            aVar = f4633a;
        }
        return aVar;
    }

    private a() {
    }

    public String b() {
        return this.f4634b;
    }

    public String c() {
        return this.c;
    }
}

package com.baidu.platform.comapi.wnplatform.f;
/* loaded from: classes15.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f4632a;

    /* renamed from: b  reason: collision with root package name */
    private String f4633b;
    private String c;

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (f4632a == null) {
                f4632a = new a();
            }
            aVar = f4632a;
        }
        return aVar;
    }

    private a() {
    }

    public String b() {
        return this.f4633b;
    }

    public String c() {
        return this.c;
    }
}

package com.baidu.platform.comapi.wnplatform.e;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f4402a;

    /* renamed from: b  reason: collision with root package name */
    private String f4403b;
    private String c;

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (f4402a == null) {
                f4402a = new a();
            }
            aVar = f4402a;
        }
        return aVar;
    }

    private a() {
    }

    public String b() {
        return this.f4403b;
    }

    public String c() {
        return this.c;
    }
}

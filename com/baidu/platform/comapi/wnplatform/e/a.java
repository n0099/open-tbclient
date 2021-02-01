package com.baidu.platform.comapi.wnplatform.e;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f4405a;

    /* renamed from: b  reason: collision with root package name */
    private String f4406b;
    private String c;

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (f4405a == null) {
                f4405a = new a();
            }
            aVar = f4405a;
        }
        return aVar;
    }

    private a() {
    }

    public String b() {
        return this.f4406b;
    }

    public String c() {
        return this.c;
    }
}

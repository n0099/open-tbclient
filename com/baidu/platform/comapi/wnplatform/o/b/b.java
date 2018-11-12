package com.baidu.platform.comapi.wnplatform.o.b;
/* loaded from: classes4.dex */
public class b {
    private com.baidu.platform.comapi.wnplatform.o.b.a.a a;
    private com.baidu.platform.comapi.wnplatform.o.b.a.b b;

    /* loaded from: classes4.dex */
    private static class a {
        private static b a = new b();
    }

    private b() {
        this.a = new com.baidu.platform.comapi.wnplatform.o.b.a.a();
        this.b = new com.baidu.platform.comapi.wnplatform.o.b.a.b();
    }

    public static b a() {
        return a.a;
    }

    public int b() {
        return this.a.a();
    }

    public int c() {
        return this.a.b();
    }

    public float d() {
        return this.a.c();
    }

    public String e() {
        return this.b.a();
    }
}

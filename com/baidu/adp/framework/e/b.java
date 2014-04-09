package com.baidu.adp.framework.e;
/* loaded from: classes.dex */
public class b extends e {
    private static b c = null;
    private f d;

    public static b a() {
        if (c == null) {
            synchronized (b.class) {
                if (c == null) {
                    c = new b();
                }
            }
        }
        return c;
    }

    private b() {
        this.d = null;
        this.a = new f(30000, 20000, 10000);
        this.d = new f(20000, 10000, 5000);
        this.b = 5;
    }

    public final f b() {
        return this.d;
    }
}

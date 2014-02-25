package com.baidu.adp.framework.e;
/* loaded from: classes.dex */
public class b extends d {
    private static b c = null;
    private e d;

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
        this.a = new e(30000, 20000, 10000);
        this.d = new e(20000, 10000, 5000);
        this.b = 5;
    }

    public e b() {
        return this.d;
    }
}

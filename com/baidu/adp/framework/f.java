package com.baidu.adp.framework;
/* loaded from: classes.dex */
public class f {
    private static f a = null;
    private int b;

    public static f a() {
        if (a == null) {
            synchronized (f.class) {
                if (a == null) {
                    a = new f();
                }
            }
        }
        return a;
    }

    private f() {
        this.b = 0;
        this.b = (int) System.currentTimeMillis();
    }

    public final synchronized int b() {
        int i;
        if (this.b >= 0 && this.b <= 100000) {
            this.b = 100001;
        }
        i = this.b;
        this.b = i + 1;
        return i;
    }
}

package com.baidu.adp.framework.c;
/* loaded from: classes.dex */
public class b extends d {
    private static b qt = null;
    private e qu;

    public static b ds() {
        if (qt == null) {
            synchronized (b.class) {
                if (qt == null) {
                    qt = new b();
                }
            }
        }
        return qt;
    }

    private b() {
        this.qu = null;
        this.qw = new e(28000, 18000, 10000);
        this.qu = new e(18000, 10000, 5000);
        this.mRetryCount = 5;
    }

    public e dt() {
        return this.qu;
    }
}

package com.baidu.adp.framework.c;
/* loaded from: classes.dex */
public class b extends d {
    private static b qs = null;
    private e qt;

    public static b ds() {
        if (qs == null) {
            synchronized (b.class) {
                if (qs == null) {
                    qs = new b();
                }
            }
        }
        return qs;
    }

    private b() {
        this.qt = null;
        this.qv = new e(28000, 18000, 10000);
        this.qt = new e(18000, 10000, 5000);
        this.mRetryCount = 5;
    }

    public e dt() {
        return this.qt;
    }
}

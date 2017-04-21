package com.baidu.adp.framework.c;
/* loaded from: classes.dex */
public class b extends d {
    private static b qV = null;
    private e qW;

    public static b ds() {
        if (qV == null) {
            synchronized (b.class) {
                if (qV == null) {
                    qV = new b();
                }
            }
        }
        return qV;
    }

    private b() {
        this.qW = null;
        this.qY = new e(28000, 18000, 10000);
        this.qW = new e(18000, 10000, 5000);
        this.mRetryCount = 5;
    }

    public e dt() {
        return this.qW;
    }
}

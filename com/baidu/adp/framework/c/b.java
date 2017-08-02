package com.baidu.adp.framework.c;
/* loaded from: classes.dex */
public class b extends d {
    private static b qW = null;
    private e qX;

    public static b dr() {
        if (qW == null) {
            synchronized (b.class) {
                if (qW == null) {
                    qW = new b();
                }
            }
        }
        return qW;
    }

    private b() {
        this.qX = null;
        this.qZ = new e(28000, 18000, 10000);
        this.qX = new e(18000, 10000, 5000);
        this.mRetryCount = 5;
    }

    public e ds() {
        return this.qX;
    }
}

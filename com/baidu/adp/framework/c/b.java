package com.baidu.adp.framework.c;
/* loaded from: classes.dex */
public class b extends d {
    private static b qU = null;
    private e qV;

    public static b fa() {
        if (qU == null) {
            synchronized (b.class) {
                if (qU == null) {
                    qU = new b();
                }
            }
        }
        return qU;
    }

    private b() {
        this.qV = null;
        this.qX = new e(28000, 18000, 10000);
        this.qV = new e(18000, 10000, 5000);
        this.mRetryCount = 5;
    }

    public e fb() {
        return this.qV;
    }
}

package com.baidu.adp.framework.c;
/* loaded from: classes.dex */
public class b extends d {
    private static b sC = null;
    private e sD;

    public static b dC() {
        if (sC == null) {
            synchronized (b.class) {
                if (sC == null) {
                    sC = new b();
                }
            }
        }
        return sC;
    }

    private b() {
        this.sD = null;
        this.sF = new e(28000, 18000, 10000);
        this.sD = new e(18000, 10000, 5000);
        this.mRetryCount = 5;
    }

    public e dD() {
        return this.sD;
    }
}

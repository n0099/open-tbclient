package com.baidu.adp.framework.c;
/* loaded from: classes.dex */
public class b extends d {
    private static b sF = null;
    private e sG;

    public static b dC() {
        if (sF == null) {
            synchronized (b.class) {
                if (sF == null) {
                    sF = new b();
                }
            }
        }
        return sF;
    }

    private b() {
        this.sG = null;
        this.sI = new e(28000, 18000, 10000);
        this.sG = new e(18000, 10000, 5000);
        this.mRetryCount = 5;
    }

    public e dD() {
        return this.sG;
    }
}

package com.baidu.adp.framework.c;
/* loaded from: classes.dex */
public class b extends d {
    private static b sE = null;
    private e sF;

    public static b dC() {
        if (sE == null) {
            synchronized (b.class) {
                if (sE == null) {
                    sE = new b();
                }
            }
        }
        return sE;
    }

    private b() {
        this.sF = null;
        this.sH = new e(28000, 18000, 10000);
        this.sF = new e(18000, 10000, 5000);
        this.mRetryCount = 5;
    }

    public e dD() {
        return this.sF;
    }
}

package com.baidu.adp.framework.c;
/* loaded from: classes.dex */
public class b extends d {
    private static b gH = null;
    private e gI;

    public static b br() {
        if (gH == null) {
            synchronized (b.class) {
                if (gH == null) {
                    gH = new b();
                }
            }
        }
        return gH;
    }

    private b() {
        this.gI = null;
        this.gK = new e(28000, 18000, 10000);
        this.gI = new e(18000, 10000, 5000);
        this.mRetryCount = 5;
    }

    public e bs() {
        return this.gI;
    }
}

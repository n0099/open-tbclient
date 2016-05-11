package com.baidu.adp.framework.c;
/* loaded from: classes.dex */
public class b extends d {
    private static b gI = null;
    private e gJ;

    public static b bq() {
        if (gI == null) {
            synchronized (b.class) {
                if (gI == null) {
                    gI = new b();
                }
            }
        }
        return gI;
    }

    private b() {
        this.gJ = null;
        this.gL = new e(28000, 18000, 10000);
        this.gJ = new e(18000, 10000, 5000);
        this.mRetryCount = 5;
    }

    public e br() {
        return this.gJ;
    }
}

package com.baidu.adp.framework.c;
/* loaded from: classes.dex */
public class b extends d {
    private static b hk = null;
    private e hl;

    public static b bq() {
        if (hk == null) {
            synchronized (b.class) {
                if (hk == null) {
                    hk = new b();
                }
            }
        }
        return hk;
    }

    private b() {
        this.hl = null;
        this.hn = new e(28000, 18000, 10000);
        this.hl = new e(18000, 10000, 5000);
        this.mRetryCount = 5;
    }

    public e br() {
        return this.hl;
    }
}

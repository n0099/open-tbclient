package com.baidu.adp.framework.c;
/* loaded from: classes.dex */
public class b extends d {
    private static b qC = null;
    private e qD;

    public static b eT() {
        if (qC == null) {
            synchronized (b.class) {
                if (qC == null) {
                    qC = new b();
                }
            }
        }
        return qC;
    }

    private b() {
        this.qD = null;
        this.qF = new e(30000, 20000, 10000);
        this.qD = new e(20000, 10000, 5000);
        this.mRetryCount = 5;
    }

    public e eU() {
        return this.qD;
    }
}

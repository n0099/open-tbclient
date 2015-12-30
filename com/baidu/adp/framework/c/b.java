package com.baidu.adp.framework.c;
/* loaded from: classes.dex */
public class b extends d {
    private static b qF = null;
    private e qG;

    public static b eT() {
        if (qF == null) {
            synchronized (b.class) {
                if (qF == null) {
                    qF = new b();
                }
            }
        }
        return qF;
    }

    private b() {
        this.qG = null;
        this.qI = new e(30000, 20000, 10000);
        this.qG = new e(20000, 10000, 5000);
        this.mRetryCount = 5;
    }

    public e eU() {
        return this.qG;
    }
}

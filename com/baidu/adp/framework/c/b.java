package com.baidu.adp.framework.c;
/* loaded from: classes.dex */
public class b extends d {
    private static b qQ = null;
    private e qR;

    public static b dr() {
        if (qQ == null) {
            synchronized (b.class) {
                if (qQ == null) {
                    qQ = new b();
                }
            }
        }
        return qQ;
    }

    private b() {
        this.qR = null;
        this.qT = new e(28000, 18000, 10000);
        this.qR = new e(18000, 10000, 5000);
        this.mRetryCount = 5;
    }

    public e ds() {
        return this.qR;
    }
}

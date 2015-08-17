package com.baidu.adp.framework.c;
/* loaded from: classes.dex */
public class b extends d {
    private static b qE = null;
    private e qF;

    public static b eW() {
        if (qE == null) {
            synchronized (b.class) {
                if (qE == null) {
                    qE = new b();
                }
            }
        }
        return qE;
    }

    private b() {
        this.qF = null;
        this.qH = new e(30000, 20000, 10000);
        this.qF = new e(20000, 10000, 5000);
        this.mRetryCount = 5;
    }

    public e eX() {
        return this.qF;
    }
}

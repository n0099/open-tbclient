package com.baidu.adp.framework.c;
/* loaded from: classes.dex */
public class b extends d {
    private static b qD = null;
    private e qE;

    public static b eV() {
        if (qD == null) {
            synchronized (b.class) {
                if (qD == null) {
                    qD = new b();
                }
            }
        }
        return qD;
    }

    private b() {
        this.qE = null;
        this.qG = new e(30000, 20000, 10000);
        this.qE = new e(20000, 10000, 5000);
        this.mRetryCount = 5;
    }

    public e eW() {
        return this.qE;
    }
}

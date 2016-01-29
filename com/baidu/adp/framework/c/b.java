package com.baidu.adp.framework.c;
/* loaded from: classes.dex */
public class b extends d {
    private static b qL = null;
    private e qM;

    public static b eZ() {
        if (qL == null) {
            synchronized (b.class) {
                if (qL == null) {
                    qL = new b();
                }
            }
        }
        return qL;
    }

    private b() {
        this.qM = null;
        this.qO = new e(30000, 20000, 10000);
        this.qM = new e(20000, 10000, 5000);
        this.mRetryCount = 5;
    }

    public e fa() {
        return this.qM;
    }
}

package com.baidu.adp.framework.c;
/* loaded from: classes.dex */
public class c extends d {
    private static c qB = null;

    public static c eT() {
        if (qB == null) {
            synchronized (c.class) {
                if (qB == null) {
                    qB = new c();
                }
            }
        }
        return qB;
    }

    private c() {
        this.qC = new e(20000, 10000, 5000);
        this.mRetryCount = 3;
    }

    public void e(int i, int i2, int i3) {
        if (i < 3000) {
            i = 3000;
        }
        if (i2 < 3000) {
            i2 = 3000;
        }
        if (i3 < 3000) {
            i3 = 3000;
        }
        this.qC = new e(i, i2, i3);
    }
}

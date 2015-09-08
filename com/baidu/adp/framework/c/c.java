package com.baidu.adp.framework.c;
/* loaded from: classes.dex */
public class c extends d {
    private static c qE = null;

    public static c eV() {
        if (qE == null) {
            synchronized (c.class) {
                if (qE == null) {
                    qE = new c();
                }
            }
        }
        return qE;
    }

    private c() {
        this.qF = new e(20000, 10000, 5000);
        this.mRetryCount = 3;
    }

    public void d(int i, int i2, int i3) {
        if (i < 3000) {
            i = 3000;
        }
        if (i2 < 3000) {
            i2 = 3000;
        }
        if (i3 < 3000) {
            i3 = 3000;
        }
        this.qF = new e(i, i2, i3);
    }
}

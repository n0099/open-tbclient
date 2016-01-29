package com.baidu.adp.framework.c;
/* loaded from: classes.dex */
public class c extends d {
    private static c qN = null;

    public static c fb() {
        if (qN == null) {
            synchronized (c.class) {
                if (qN == null) {
                    qN = new c();
                }
            }
        }
        return qN;
    }

    private c() {
        this.qO = new e(20000, 10000, 5000);
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
        this.qO = new e(i, i2, i3);
    }
}

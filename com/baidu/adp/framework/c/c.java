package com.baidu.adp.framework.c;
/* loaded from: classes.dex */
public class c extends d {
    private static c qx = null;

    public static c du() {
        if (qx == null) {
            synchronized (c.class) {
                if (qx == null) {
                    qx = new c();
                }
            }
        }
        return qx;
    }

    private c() {
        this.qy = new e(20000, 10000, 5000);
        this.mRetryCount = 3;
    }

    public void c(int i, int i2, int i3) {
        if (i < 3000) {
            i = 3000;
        }
        if (i2 < 3000) {
            i2 = 3000;
        }
        if (i3 < 3000) {
            i3 = 3000;
        }
        this.qy = new e(i, i2, i3);
    }
}

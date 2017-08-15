package com.baidu.adp.framework.c;
/* loaded from: classes.dex */
public class c extends d {
    private static c sG = null;

    public static c dE() {
        if (sG == null) {
            synchronized (c.class) {
                if (sG == null) {
                    sG = new c();
                }
            }
        }
        return sG;
    }

    private c() {
        this.sH = new e(20000, 10000, 5000);
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
        this.sH = new e(i, i2, i3);
    }
}

package com.baidu.adp.framework.c;
/* loaded from: classes.dex */
public class c extends d {
    private static c wn = null;

    public static c gp() {
        if (wn == null) {
            synchronized (c.class) {
                if (wn == null) {
                    wn = new c();
                }
            }
        }
        return wn;
    }

    private c() {
        this.wo = new e(20000, 10000, 5000);
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
        this.wo = new e(i, i2, i3);
    }
}

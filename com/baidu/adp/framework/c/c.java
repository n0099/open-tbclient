package com.baidu.adp.framework.c;
/* loaded from: classes.dex */
public class c extends d {
    private static c sE = null;

    public static c dE() {
        if (sE == null) {
            synchronized (c.class) {
                if (sE == null) {
                    sE = new c();
                }
            }
        }
        return sE;
    }

    private c() {
        this.sF = new e(20000, 10000, 5000);
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
        this.sF = new e(i, i2, i3);
    }
}

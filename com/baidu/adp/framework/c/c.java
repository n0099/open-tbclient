package com.baidu.adp.framework.c;
/* loaded from: classes.dex */
public class c extends d {
    private static c aeX = null;

    public static c kY() {
        if (aeX == null) {
            synchronized (c.class) {
                if (aeX == null) {
                    aeX = new c();
                }
            }
        }
        return aeX;
    }

    private c() {
        this.aeY = new e(20000, 10000, 5000);
        this.mRetryCount = 3;
    }

    public void l(int i, int i2, int i3) {
        if (i < 3000) {
            i = 3000;
        }
        if (i2 < 3000) {
            i2 = 3000;
        }
        if (i3 < 3000) {
            i3 = 3000;
        }
        this.aeY = new e(i, i2, i3);
    }
}

package com.baidu.adp.framework.c;
/* loaded from: classes.dex */
public class c extends d {
    private static c qF = null;

    public static c eX() {
        if (qF == null) {
            synchronized (c.class) {
                if (qF == null) {
                    qF = new c();
                }
            }
        }
        return qF;
    }

    private c() {
        this.qG = new e(20000, 10000, 5000);
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
        this.qG = new e(i, i2, i3);
    }
}

package com.baidu.adp.framework.c;
/* loaded from: classes.dex */
public class c extends d {
    private static c qS = null;

    public static c dt() {
        if (qS == null) {
            synchronized (c.class) {
                if (qS == null) {
                    qS = new c();
                }
            }
        }
        return qS;
    }

    private c() {
        this.qT = new e(20000, 10000, 5000);
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
        this.qT = new e(i, i2, i3);
    }
}

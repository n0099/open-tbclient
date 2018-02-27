package com.baidu.adp.framework.c;

import com.baidu.ar.util.Constants;
/* loaded from: classes.dex */
public class c extends d {
    private static c aeP = null;

    public static c kY() {
        if (aeP == null) {
            synchronized (c.class) {
                if (aeP == null) {
                    aeP = new c();
                }
            }
        }
        return aeP;
    }

    private c() {
        this.aeQ = new e(Constants.HTTP_CONNECT_TIMEOUT, 10000, 5000);
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
        this.aeQ = new e(i, i2, i3);
    }
}

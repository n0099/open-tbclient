package com.baidu.adp.framework.c;

import com.baidu.ar.constants.HttpConstants;
/* loaded from: classes.dex */
public class c extends d {
    private static c xP = null;

    public static c gY() {
        if (xP == null) {
            synchronized (c.class) {
                if (xP == null) {
                    xP = new c();
                }
            }
        }
        return xP;
    }

    private c() {
        this.xQ = new e(HttpConstants.HTTP_CONNECT_TIMEOUT, 10000, 5000);
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
        this.xQ = new e(i, i2, i3);
    }
}

package com.baidu.adp.framework.c;

import com.baidu.ar.constants.HttpConstants;
/* loaded from: classes.dex */
public class c extends d {
    private static c vv = null;

    public static c fQ() {
        if (vv == null) {
            synchronized (c.class) {
                if (vv == null) {
                    vv = new c();
                }
            }
        }
        return vv;
    }

    private c() {
        this.vw = new e(HttpConstants.HTTP_CONNECT_TIMEOUT, 10000, 5000);
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
        this.vw = new e(i, i2, i3);
    }
}

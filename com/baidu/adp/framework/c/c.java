package com.baidu.adp.framework.c;

import com.baidu.live.adp.framework.MessageConfig;
/* loaded from: classes.dex */
public class c extends d {
    private static c ou = null;

    public static c fe() {
        if (ou == null) {
            synchronized (c.class) {
                if (ou == null) {
                    ou = new c();
                }
            }
        }
        return ou;
    }

    private c() {
        this.ov = new e(MessageConfig.SOCKET_TIME_OUT_MS_2G, 10000, 5000);
        this.mRetryCount = 3;
    }

    public void setTimeOutData(int i, int i2, int i3) {
        if (i < 3000) {
            i = 3000;
        }
        if (i2 < 3000) {
            i2 = 3000;
        }
        if (i3 < 3000) {
            i3 = 3000;
        }
        this.ov = new e(i, i2, i3);
    }
}

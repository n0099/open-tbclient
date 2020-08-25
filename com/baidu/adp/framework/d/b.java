package com.baidu.adp.framework.d;

import com.baidu.live.adp.framework.MessageConfig;
/* loaded from: classes.dex */
public class b extends d {
    private static b IW = null;
    private e IX;

    public static b ly() {
        if (IW == null) {
            synchronized (b.class) {
                if (IW == null) {
                    IW = new b();
                }
            }
        }
        return IW;
    }

    private b() {
        this.IX = null;
        this.IZ = new e(MessageConfig.HTTP_TIME_OUT_MS_2G, 18000, 10000);
        this.IX = new e(18000, 10000, 5000);
        this.mRetryCount = 3;
    }

    public e lz() {
        return this.IX;
    }
}

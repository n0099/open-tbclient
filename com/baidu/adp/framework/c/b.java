package com.baidu.adp.framework.c;

import com.baidu.live.adp.framework.MessageConfig;
/* loaded from: classes.dex */
public class b extends d {
    private static b HB = null;
    private e HC;

    public static b jH() {
        if (HB == null) {
            synchronized (b.class) {
                if (HB == null) {
                    HB = new b();
                }
            }
        }
        return HB;
    }

    private b() {
        this.HC = null;
        this.HE = new e(MessageConfig.HTTP_TIME_OUT_MS_2G, 18000, 10000);
        this.HC = new e(18000, 10000, 5000);
        this.mRetryCount = 3;
    }

    public e jI() {
        return this.HC;
    }
}

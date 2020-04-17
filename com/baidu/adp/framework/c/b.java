package com.baidu.adp.framework.c;

import com.baidu.live.adp.framework.MessageConfig;
/* loaded from: classes.dex */
public class b extends d {
    private static b Hy = null;
    private e Hz;

    public static b jH() {
        if (Hy == null) {
            synchronized (b.class) {
                if (Hy == null) {
                    Hy = new b();
                }
            }
        }
        return Hy;
    }

    private b() {
        this.Hz = null;
        this.HB = new e(MessageConfig.HTTP_TIME_OUT_MS_2G, 18000, 10000);
        this.Hz = new e(18000, 10000, 5000);
        this.mRetryCount = 3;
    }

    public e jI() {
        return this.Hz;
    }
}

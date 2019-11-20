package com.baidu.adp.framework.c;

import com.baidu.live.adp.framework.MessageConfig;
/* loaded from: classes.dex */
public class b extends d {
    private static b lU = null;
    private e lV;

    public static b eH() {
        if (lU == null) {
            synchronized (b.class) {
                if (lU == null) {
                    lU = new b();
                }
            }
        }
        return lU;
    }

    private b() {
        this.lV = null;
        this.lX = new e(MessageConfig.HTTP_TIME_OUT_MS_2G, 18000, 10000);
        this.lV = new e(18000, 10000, 5000);
        this.mRetryCount = 3;
    }

    public e eI() {
        return this.lV;
    }
}

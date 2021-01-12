package com.baidu.adp.framework.d;

import com.baidu.live.adp.framework.MessageConfig;
/* loaded from: classes.dex */
public class b extends d {
    private static b JK = null;
    private e JL;

    public static b kZ() {
        if (JK == null) {
            synchronized (b.class) {
                if (JK == null) {
                    JK = new b();
                }
            }
        }
        return JK;
    }

    private b() {
        this.JL = null;
        this.JN = new e(MessageConfig.HTTP_TIME_OUT_MS_2G, 18000, 10000);
        this.JL = new e(18000, 10000, 5000);
        this.mRetryCount = 3;
    }

    public e la() {
        return this.JL;
    }
}

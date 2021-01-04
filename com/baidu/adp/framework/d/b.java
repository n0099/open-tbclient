package com.baidu.adp.framework.d;

import com.baidu.live.adp.framework.MessageConfig;
/* loaded from: classes.dex */
public class b extends d {
    private static b JM = null;
    private e JN;

    public static b kZ() {
        if (JM == null) {
            synchronized (b.class) {
                if (JM == null) {
                    JM = new b();
                }
            }
        }
        return JM;
    }

    private b() {
        this.JN = null;
        this.JP = new e(MessageConfig.HTTP_TIME_OUT_MS_2G, 18000, 10000);
        this.JN = new e(18000, 10000, 5000);
        this.mRetryCount = 3;
    }

    public e la() {
        return this.JN;
    }
}

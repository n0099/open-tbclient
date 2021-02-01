package com.baidu.adp.framework.d;

import com.baidu.live.adp.framework.MessageConfig;
/* loaded from: classes.dex */
public class b extends d {
    private static b JJ = null;
    private e JK;

    public static b kY() {
        if (JJ == null) {
            synchronized (b.class) {
                if (JJ == null) {
                    JJ = new b();
                }
            }
        }
        return JJ;
    }

    private b() {
        this.JK = null;
        this.JM = new e(MessageConfig.HTTP_TIME_OUT_MS_2G, 18000, 10000);
        this.JK = new e(18000, 10000, 5000);
        this.mRetryCount = 3;
    }

    public e kZ() {
        return this.JK;
    }
}

package com.baidu.adp.framework.d;

import com.baidu.live.adp.framework.MessageConfig;
/* loaded from: classes.dex */
public class b extends d {
    private static b Lc = null;
    private e Ld;

    public static b kY() {
        if (Lc == null) {
            synchronized (b.class) {
                if (Lc == null) {
                    Lc = new b();
                }
            }
        }
        return Lc;
    }

    private b() {
        this.Ld = null;
        this.Lf = new e(MessageConfig.HTTP_TIME_OUT_MS_2G, 18000, 10000);
        this.Ld = new e(18000, 10000, 5000);
        this.mRetryCount = 3;
    }

    public e kZ() {
        return this.Ld;
    }
}

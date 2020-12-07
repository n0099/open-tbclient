package com.baidu.adp.framework.d;

import com.baidu.live.adp.framework.MessageConfig;
/* loaded from: classes.dex */
public class b extends d {
    private static b Km = null;
    private e Kn;

    public static b lD() {
        if (Km == null) {
            synchronized (b.class) {
                if (Km == null) {
                    Km = new b();
                }
            }
        }
        return Km;
    }

    private b() {
        this.Kn = null;
        this.Kp = new e(MessageConfig.HTTP_TIME_OUT_MS_2G, 18000, 10000);
        this.Kn = new e(18000, 10000, 5000);
        this.mRetryCount = 3;
    }

    public e lE() {
        return this.Kn;
    }
}

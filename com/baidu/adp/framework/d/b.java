package com.baidu.adp.framework.d;

import com.baidu.live.adp.framework.MessageConfig;
/* loaded from: classes.dex */
public class b extends d {
    private static b Je = null;
    private e Jf;

    public static b lC() {
        if (Je == null) {
            synchronized (b.class) {
                if (Je == null) {
                    Je = new b();
                }
            }
        }
        return Je;
    }

    private b() {
        this.Jf = null;
        this.Jh = new e(MessageConfig.HTTP_TIME_OUT_MS_2G, 18000, 10000);
        this.Jf = new e(18000, 10000, 5000);
        this.mRetryCount = 3;
    }

    public e lD() {
        return this.Jf;
    }
}

package com.baidu.adp.framework.c;

import com.baidu.live.adp.framework.MessageConfig;
/* loaded from: classes.dex */
public class b extends d {
    private static b oq = null;
    private e or;

    public static b fb() {
        if (oq == null) {
            synchronized (b.class) {
                if (oq == null) {
                    oq = new b();
                }
            }
        }
        return oq;
    }

    private b() {
        this.or = null;
        this.ou = new e(MessageConfig.HTTP_TIME_OUT_MS_2G, 18000, 10000);
        this.or = new e(18000, 10000, 5000);
        this.mRetryCount = 3;
    }

    public e fc() {
        return this.or;
    }
}

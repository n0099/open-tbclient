package com.baidu.adp.framework.c;

import com.baidu.live.adp.framework.MessageConfig;
/* loaded from: classes.dex */
public class b extends d {
    private static b om = null;
    private e on;

    public static b fb() {
        if (om == null) {
            synchronized (b.class) {
                if (om == null) {
                    om = new b();
                }
            }
        }
        return om;
    }

    private b() {
        this.on = null;
        this.oq = new e(MessageConfig.HTTP_TIME_OUT_MS_2G, 18000, 10000);
        this.on = new e(18000, 10000, 5000);
        this.mRetryCount = 3;
    }

    public e fc() {
        return this.on;
    }
}

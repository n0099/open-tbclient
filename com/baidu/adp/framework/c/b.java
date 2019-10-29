package com.baidu.adp.framework.c;

import com.baidu.live.adp.framework.MessageConfig;
/* loaded from: classes.dex */
public class b extends d {
    private static b mw = null;
    private e mx;

    public static b eH() {
        if (mw == null) {
            synchronized (b.class) {
                if (mw == null) {
                    mw = new b();
                }
            }
        }
        return mw;
    }

    private b() {
        this.mx = null;
        this.mz = new e(MessageConfig.HTTP_TIME_OUT_MS_2G, 18000, 10000);
        this.mx = new e(18000, 10000, 5000);
        this.mRetryCount = 3;
    }

    public e eI() {
        return this.mx;
    }
}

package com.baidu.adp.framework.c;

import com.baidu.live.adp.framework.MessageConfig;
/* loaded from: classes.dex */
public class b extends d {
    private static b or = null;
    private e ot;

    public static b fc() {
        if (or == null) {
            synchronized (b.class) {
                if (or == null) {
                    or = new b();
                }
            }
        }
        return or;
    }

    private b() {
        this.ot = null;
        this.ov = new e(MessageConfig.HTTP_TIME_OUT_MS_2G, 18000, 10000);
        this.ot = new e(18000, 10000, 5000);
        this.mRetryCount = 3;
    }

    public e fd() {
        return this.ot;
    }
}

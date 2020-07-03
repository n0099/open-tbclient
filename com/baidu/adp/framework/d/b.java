package com.baidu.adp.framework.d;

import com.baidu.live.adp.framework.MessageConfig;
/* loaded from: classes.dex */
public class b extends d {
    private static b In = null;
    private e Io;

    public static b jZ() {
        if (In == null) {
            synchronized (b.class) {
                if (In == null) {
                    In = new b();
                }
            }
        }
        return In;
    }

    private b() {
        this.Io = null;
        this.Iq = new e(MessageConfig.HTTP_TIME_OUT_MS_2G, 18000, 10000);
        this.Io = new e(18000, 10000, 5000);
        this.mRetryCount = 3;
    }

    public e ka() {
        return this.Io;
    }
}

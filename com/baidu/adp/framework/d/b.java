package com.baidu.adp.framework.d;

import com.baidu.live.adp.framework.MessageConfig;
/* loaded from: classes.dex */
public class b extends d {
    private static b Ju = null;
    private e Jv;

    public static b lD() {
        if (Ju == null) {
            synchronized (b.class) {
                if (Ju == null) {
                    Ju = new b();
                }
            }
        }
        return Ju;
    }

    private b() {
        this.Jv = null;
        this.Jx = new e(MessageConfig.HTTP_TIME_OUT_MS_2G, 18000, 10000);
        this.Jv = new e(18000, 10000, 5000);
        this.mRetryCount = 3;
    }

    public e lE() {
        return this.Jv;
    }
}

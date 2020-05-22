package com.baidu.adp.framework.d;

import com.baidu.live.adp.framework.MessageConfig;
/* loaded from: classes.dex */
public class b extends d {
    private static b HM = null;
    private e HN;

    public static b jJ() {
        if (HM == null) {
            synchronized (b.class) {
                if (HM == null) {
                    HM = new b();
                }
            }
        }
        return HM;
    }

    private b() {
        this.HN = null;
        this.HP = new e(MessageConfig.HTTP_TIME_OUT_MS_2G, 18000, 10000);
        this.HN = new e(18000, 10000, 5000);
        this.mRetryCount = 3;
    }

    public e jK() {
        return this.HN;
    }
}

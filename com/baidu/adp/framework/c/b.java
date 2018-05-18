package com.baidu.adp.framework.c;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class b extends d {
    private static b pj = null;
    private e pl;

    public static b da() {
        if (pj == null) {
            synchronized (b.class) {
                if (pj == null) {
                    pj = new b();
                }
            }
        }
        return pj;
    }

    private b() {
        this.pl = null;
        this.pp = new e(28000, TbConfig.POST_IMAGE_HIGHT_LIMIT, 10000);
        this.pl = new e(TbConfig.POST_IMAGE_HIGHT_LIMIT, 10000, 5000);
        this.mRetryCount = 5;
    }

    public e db() {
        return this.pl;
    }
}

package com.baidu.adp.framework.c;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class b extends d {
    private static b pl = null;
    private e po;

    public static b da() {
        if (pl == null) {
            synchronized (b.class) {
                if (pl == null) {
                    pl = new b();
                }
            }
        }
        return pl;
    }

    private b() {
        this.po = null;
        this.pq = new e(28000, TbConfig.POST_IMAGE_HIGHT_LIMIT, 10000);
        this.po = new e(TbConfig.POST_IMAGE_HIGHT_LIMIT, 10000, 5000);
        this.mRetryCount = 5;
    }

    public e db() {
        return this.po;
    }
}

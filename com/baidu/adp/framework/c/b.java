package com.baidu.adp.framework.c;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class b extends d {
    private static b aeV = null;
    private e aeW;

    public static b kW() {
        if (aeV == null) {
            synchronized (b.class) {
                if (aeV == null) {
                    aeV = new b();
                }
            }
        }
        return aeV;
    }

    private b() {
        this.aeW = null;
        this.aeY = new e(28000, TbConfig.POST_IMAGE_HIGHT_LIMIT, 10000);
        this.aeW = new e(TbConfig.POST_IMAGE_HIGHT_LIMIT, 10000, 5000);
        this.mRetryCount = 5;
    }

    public e kX() {
        return this.aeW;
    }
}

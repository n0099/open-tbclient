package com.baidu.adp.framework.c;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class b extends d {
    private static b aeT = null;
    private e aeU;

    public static b kW() {
        if (aeT == null) {
            synchronized (b.class) {
                if (aeT == null) {
                    aeT = new b();
                }
            }
        }
        return aeT;
    }

    private b() {
        this.aeU = null;
        this.aeW = new e(28000, TbConfig.POST_IMAGE_HIGHT_LIMIT, 10000);
        this.aeU = new e(TbConfig.POST_IMAGE_HIGHT_LIMIT, 10000, 5000);
        this.mRetryCount = 5;
    }

    public e kX() {
        return this.aeU;
    }
}

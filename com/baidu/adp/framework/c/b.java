package com.baidu.adp.framework.c;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class b extends d {
    private static b aeN = null;
    private e aeO;

    public static b kW() {
        if (aeN == null) {
            synchronized (b.class) {
                if (aeN == null) {
                    aeN = new b();
                }
            }
        }
        return aeN;
    }

    private b() {
        this.aeO = null;
        this.aeQ = new e(28000, TbConfig.POST_IMAGE_HIGHT_LIMIT, 10000);
        this.aeO = new e(TbConfig.POST_IMAGE_HIGHT_LIMIT, 10000, 5000);
        this.mRetryCount = 5;
    }

    public e kX() {
        return this.aeO;
    }
}

package com.baidu.adp.framework.c;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class b extends d {
    private static b vB = null;
    private e vC;

    public static b fP() {
        if (vB == null) {
            synchronized (b.class) {
                if (vB == null) {
                    vB = new b();
                }
            }
        }
        return vB;
    }

    private b() {
        this.vC = null;
        this.vE = new e(28000, TbConfig.POST_IMAGE_HIGHT_LIMIT, 10000);
        this.vC = new e(TbConfig.POST_IMAGE_HIGHT_LIMIT, 10000, 5000);
        this.mRetryCount = 5;
    }

    public e fQ() {
        return this.vC;
    }
}

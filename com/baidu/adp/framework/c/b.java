package com.baidu.adp.framework.c;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class b extends d {
    private static b vD = null;
    private e vE;

    public static b fP() {
        if (vD == null) {
            synchronized (b.class) {
                if (vD == null) {
                    vD = new b();
                }
            }
        }
        return vD;
    }

    private b() {
        this.vE = null;
        this.vG = new e(28000, TbConfig.POST_IMAGE_HIGHT_LIMIT, 10000);
        this.vE = new e(TbConfig.POST_IMAGE_HIGHT_LIMIT, 10000, 5000);
        this.mRetryCount = 5;
    }

    public e fQ() {
        return this.vE;
    }
}

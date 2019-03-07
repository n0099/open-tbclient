package com.baidu.adp.framework.c;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class b extends d {
    private static b yz = null;
    private e yA;

    public static b hk() {
        if (yz == null) {
            synchronized (b.class) {
                if (yz == null) {
                    yz = new b();
                }
            }
        }
        return yz;
    }

    private b() {
        this.yA = null;
        this.yC = new e(28000, TbConfig.POST_IMAGE_HIGHT_LIMIT, 10000);
        this.yA = new e(TbConfig.POST_IMAGE_HIGHT_LIMIT, 10000, 5000);
        this.mRetryCount = 3;
    }

    public e hl() {
        return this.yA;
    }
}

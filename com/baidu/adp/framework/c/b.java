package com.baidu.adp.framework.c;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class b extends d {
    private static b xN = null;
    private e xO;

    public static b gW() {
        if (xN == null) {
            synchronized (b.class) {
                if (xN == null) {
                    xN = new b();
                }
            }
        }
        return xN;
    }

    private b() {
        this.xO = null;
        this.xQ = new e(28000, TbConfig.POST_IMAGE_HIGHT_LIMIT, 10000);
        this.xO = new e(TbConfig.POST_IMAGE_HIGHT_LIMIT, 10000, 5000);
        this.mRetryCount = 3;
    }

    public e gX() {
        return this.xO;
    }
}

package com.baidu.adp.framework.c;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class b extends d {
    private static b vu = null;
    private e vv;

    public static b fO() {
        if (vu == null) {
            synchronized (b.class) {
                if (vu == null) {
                    vu = new b();
                }
            }
        }
        return vu;
    }

    private b() {
        this.vv = null;
        this.vx = new e(28000, TbConfig.POST_IMAGE_HIGHT_LIMIT, 10000);
        this.vv = new e(TbConfig.POST_IMAGE_HIGHT_LIMIT, 10000, 5000);
        this.mRetryCount = 3;
    }

    public e fP() {
        return this.vv;
    }
}

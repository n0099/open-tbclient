package com.baidu.adp.framework.c;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class b extends d {
    private static b qu = null;
    private e qv;

    public static b ds() {
        if (qu == null) {
            synchronized (b.class) {
                if (qu == null) {
                    qu = new b();
                }
            }
        }
        return qu;
    }

    private b() {
        this.qv = null;
        this.qx = new e(28000, TbConfig.POST_IMAGE_HIGHT_LIMIT, 10000);
        this.qv = new e(TbConfig.POST_IMAGE_HIGHT_LIMIT, 10000, 5000);
        this.mRetryCount = 5;
    }

    public e dt() {
        return this.qv;
    }
}

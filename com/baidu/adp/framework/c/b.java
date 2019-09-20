package com.baidu.adp.framework.c;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class b extends d {
    private static b wk = null;
    private e wl;

    public static b gn() {
        if (wk == null) {
            synchronized (b.class) {
                if (wk == null) {
                    wk = new b();
                }
            }
        }
        return wk;
    }

    private b() {
        this.wl = null;
        this.wo = new e(28000, TbConfig.POST_IMAGE_HIGHT_LIMIT, 10000);
        this.wl = new e(TbConfig.POST_IMAGE_HIGHT_LIMIT, 10000, 5000);
        this.mRetryCount = 3;
    }

    public e go() {
        return this.wl;
    }
}

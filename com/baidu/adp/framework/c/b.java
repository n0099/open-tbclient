package com.baidu.adp.framework.c;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class b extends d {
    private static b vt = null;
    private e vu;

    public static b fO() {
        if (vt == null) {
            synchronized (b.class) {
                if (vt == null) {
                    vt = new b();
                }
            }
        }
        return vt;
    }

    private b() {
        this.vu = null;
        this.vw = new e(28000, TbConfig.POST_IMAGE_HIGHT_LIMIT, 10000);
        this.vu = new e(TbConfig.POST_IMAGE_HIGHT_LIMIT, 10000, 5000);
        this.mRetryCount = 3;
    }

    public e fP() {
        return this.vu;
    }
}

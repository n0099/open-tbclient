package com.baidu.adp.framework.c;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class b extends d {
    private static b qv = null;
    private e qw;

    public static b ds() {
        if (qv == null) {
            synchronized (b.class) {
                if (qv == null) {
                    qv = new b();
                }
            }
        }
        return qv;
    }

    private b() {
        this.qw = null;
        this.qy = new e(28000, TbConfig.POST_IMAGE_HIGHT_LIMIT, 10000);
        this.qw = new e(TbConfig.POST_IMAGE_HIGHT_LIMIT, 10000, 5000);
        this.mRetryCount = 5;
    }

    public e dt() {
        return this.qw;
    }
}

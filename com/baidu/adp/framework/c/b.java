package com.baidu.adp.framework.c;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class b extends d {
    private static b cZ = null;
    private e da;

    public static b aV() {
        if (cZ == null) {
            synchronized (b.class) {
                if (cZ == null) {
                    cZ = new b();
                }
            }
        }
        return cZ;
    }

    private b() {
        this.da = null;
        this.dc = new e(30000, 20000, TbConfig.BIG_IMAGE_MIN_CAPACITY);
        this.da = new e(20000, TbConfig.BIG_IMAGE_MIN_CAPACITY, 5000);
        this.mRetryCount = 5;
    }

    public e aW() {
        return this.da;
    }
}

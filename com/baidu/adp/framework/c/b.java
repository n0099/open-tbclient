package com.baidu.adp.framework.c;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class b extends d {
    private static b fh = null;
    private e fi;

    public static b bu() {
        if (fh == null) {
            synchronized (b.class) {
                if (fh == null) {
                    fh = new b();
                }
            }
        }
        return fh;
    }

    private b() {
        this.fi = null;
        this.fk = new e(30000, 20000, TbConfig.BIG_IMAGE_MIN_CAPACITY);
        this.fi = new e(20000, TbConfig.BIG_IMAGE_MIN_CAPACITY, 5000);
        this.mRetryCount = 5;
    }

    public e bv() {
        return this.fi;
    }
}

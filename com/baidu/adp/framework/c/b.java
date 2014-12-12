package com.baidu.adp.framework.c;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class b extends d {
    private static b ff = null;
    private e fg;

    public static b bw() {
        if (ff == null) {
            synchronized (b.class) {
                if (ff == null) {
                    ff = new b();
                }
            }
        }
        return ff;
    }

    private b() {
        this.fg = null;
        this.fi = new e(30000, 20000, TbConfig.BIG_IMAGE_MIN_CAPACITY);
        this.fg = new e(20000, TbConfig.BIG_IMAGE_MIN_CAPACITY, 5000);
        this.mRetryCount = 5;
    }

    public e bx() {
        return this.fg;
    }
}

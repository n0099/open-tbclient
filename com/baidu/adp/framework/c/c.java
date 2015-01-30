package com.baidu.adp.framework.c;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class c extends d {
    private static c fj = null;

    public static c bw() {
        if (fj == null) {
            synchronized (c.class) {
                if (fj == null) {
                    fj = new c();
                }
            }
        }
        return fj;
    }

    private c() {
        this.fk = new e(20000, TbConfig.BIG_IMAGE_MIN_CAPACITY, 5000);
        this.mRetryCount = 3;
    }

    public void e(int i, int i2, int i3) {
        if (i < 3000) {
            i = 3000;
        }
        if (i2 < 3000) {
            i2 = 3000;
        }
        if (i3 < 3000) {
            i3 = 3000;
        }
        this.fk = new e(i, i2, i3);
    }
}

package com.baidu.adp.framework.c;

import com.baidu.kirin.KirinConfig;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class c extends d {
    private static c c = null;

    public static c a() {
        if (c == null) {
            synchronized (c.class) {
                if (c == null) {
                    c = new c();
                }
            }
        }
        return c;
    }

    private c() {
        this.a = new e(20000, TbConfig.BIG_IMAGE_MIN_CAPACITY, KirinConfig.READ_TIME_OUT);
        this.b = 3;
    }

    public void a(int i, int i2, int i3) {
        if (i < 3000) {
            i = 3000;
        }
        if (i2 < 3000) {
            i2 = 3000;
        }
        if (i3 < 3000) {
            i3 = 3000;
        }
        this.a = new e(i, i2, i3);
    }
}

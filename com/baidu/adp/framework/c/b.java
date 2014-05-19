package com.baidu.adp.framework.c;

import com.baidu.kirin.KirinConfig;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class b extends f {
    private static b c = null;
    private g d;

    public static b a() {
        if (c == null) {
            synchronized (b.class) {
                if (c == null) {
                    c = new b();
                }
            }
        }
        return c;
    }

    private b() {
        this.d = null;
        this.a = new g(30000, 20000, TbConfig.BIG_IMAGE_MIN_CAPACITY);
        this.d = new g(20000, TbConfig.BIG_IMAGE_MIN_CAPACITY, KirinConfig.READ_TIME_OUT);
        this.b = 5;
    }

    public g b() {
        return this.d;
    }
}

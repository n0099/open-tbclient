package com.baidu.adp.framework.c;
/* loaded from: classes.dex */
public class b extends d {
    private static b jw = null;
    private e jx;

    public static b cj() {
        if (jw == null) {
            synchronized (b.class) {
                if (jw == null) {
                    jw = new b();
                }
            }
        }
        return jw;
    }

    private b() {
        this.jx = null;
        this.jz = new e(28000, 18000, 10000);
        this.jx = new e(18000, 10000, 5000);
        this.mRetryCount = 5;
    }

    public e ck() {
        return this.jx;
    }
}

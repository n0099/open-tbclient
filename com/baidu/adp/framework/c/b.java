package com.baidu.adp.framework.c;
/* loaded from: classes.dex */
public class b extends d {
    private static b jD = null;
    private e jE;

    public static b cl() {
        if (jD == null) {
            synchronized (b.class) {
                if (jD == null) {
                    jD = new b();
                }
            }
        }
        return jD;
    }

    private b() {
        this.jE = null;
        this.jG = new e(28000, 18000, 10000);
        this.jE = new e(18000, 10000, 5000);
        this.mRetryCount = 5;
    }

    public e cm() {
        return this.jE;
    }
}

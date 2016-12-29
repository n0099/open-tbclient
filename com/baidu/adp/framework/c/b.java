package com.baidu.adp.framework.c;
/* loaded from: classes.dex */
public class b extends d {
    private static b jC = null;
    private e jD;

    public static b cl() {
        if (jC == null) {
            synchronized (b.class) {
                if (jC == null) {
                    jC = new b();
                }
            }
        }
        return jC;
    }

    private b() {
        this.jD = null;
        this.jF = new e(28000, 18000, 10000);
        this.jD = new e(18000, 10000, 5000);
        this.mRetryCount = 5;
    }

    public e cm() {
        return this.jD;
    }
}

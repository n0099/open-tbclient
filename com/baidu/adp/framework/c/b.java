package com.baidu.adp.framework.c;
/* loaded from: classes.dex */
public class b extends d {
    private static b rs = null;
    private e rt;

    public static b ds() {
        if (rs == null) {
            synchronized (b.class) {
                if (rs == null) {
                    rs = new b();
                }
            }
        }
        return rs;
    }

    private b() {
        this.rt = null;
        this.rv = new e(28000, 18000, 10000);
        this.rt = new e(18000, 10000, 5000);
        this.mRetryCount = 5;
    }

    public e dt() {
        return this.rt;
    }
}

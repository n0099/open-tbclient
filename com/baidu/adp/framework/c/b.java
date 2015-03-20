package com.baidu.adp.framework.c;
/* loaded from: classes.dex */
public class b extends d {
    private static b qz = null;
    private e qA;

    public static b eR() {
        if (qz == null) {
            synchronized (b.class) {
                if (qz == null) {
                    qz = new b();
                }
            }
        }
        return qz;
    }

    private b() {
        this.qA = null;
        this.qC = new e(30000, 20000, 10000);
        this.qA = new e(20000, 10000, 5000);
        this.mRetryCount = 5;
    }

    public e eS() {
        return this.qA;
    }
}

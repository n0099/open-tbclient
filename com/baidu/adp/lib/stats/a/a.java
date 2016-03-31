package com.baidu.adp.lib.stats.a;
/* loaded from: classes.dex */
public class a {
    private static a xF = null;
    private long clientLogID = 0;

    public static a iw() {
        if (xF == null) {
            synchronized (a.class) {
                if (xF == null) {
                    xF = new a();
                }
            }
        }
        return xF;
    }

    public synchronized long hB() {
        if (this.clientLogID > 0) {
            this.clientLogID++;
        } else {
            this.clientLogID = System.currentTimeMillis();
        }
        return this.clientLogID;
    }
}

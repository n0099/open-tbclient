package com.baidu.adp.lib.stats.a;
/* loaded from: classes.dex */
public class a {
    private static a wV = null;
    private long clientLogID = 0;

    public static a gy() {
        if (wV == null) {
            synchronized (a.class) {
                if (wV == null) {
                    wV = new a();
                }
            }
        }
        return wV;
    }

    public synchronized long getClientLogId() {
        if (this.clientLogID > 0) {
            this.clientLogID++;
        } else {
            this.clientLogID = System.currentTimeMillis();
        }
        return this.clientLogID;
    }
}

package com.baidu.adp.lib.stats.a;
/* loaded from: classes.dex */
public class a {
    private static a Mx = null;
    private long clientLogID = 0;

    public static a lU() {
        if (Mx == null) {
            synchronized (a.class) {
                if (Mx == null) {
                    Mx = new a();
                }
            }
        }
        return Mx;
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

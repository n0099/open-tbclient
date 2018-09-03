package com.baidu.adp.lib.stats.a;
/* loaded from: classes.dex */
public class a {
    private static a BI = null;
    private long clientLogID = 0;

    public static a iV() {
        if (BI == null) {
            synchronized (a.class) {
                if (BI == null) {
                    BI = new a();
                }
            }
        }
        return BI;
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

package com.baidu.adp.lib.stats.a;
/* loaded from: classes.dex */
public class a {
    private static a tj = null;
    private long clientLogID = 0;

    public static a hc() {
        if (tj == null) {
            synchronized (a.class) {
                if (tj == null) {
                    tj = new a();
                }
            }
        }
        return tj;
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

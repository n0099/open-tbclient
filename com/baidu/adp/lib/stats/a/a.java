package com.baidu.adp.lib.stats.a;
/* loaded from: classes.dex */
public class a {
    private static a NP = null;
    private long clientLogID = 0;

    public static a nL() {
        if (NP == null) {
            synchronized (a.class) {
                if (NP == null) {
                    NP = new a();
                }
            }
        }
        return NP;
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

package com.baidu.adp.lib.stats.a;
/* loaded from: classes.dex */
public class a {
    private static a Mt = null;
    private long clientLogID = 0;

    public static a lU() {
        if (Mt == null) {
            synchronized (a.class) {
                if (Mt == null) {
                    Mt = new a();
                }
            }
        }
        return Mt;
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

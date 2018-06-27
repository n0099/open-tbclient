package com.baidu.adp.lib.stats.a;
/* loaded from: classes.dex */
public class a {
    private static a BM = null;
    private long clientLogID = 0;

    public static a iU() {
        if (BM == null) {
            synchronized (a.class) {
                if (BM == null) {
                    BM = new a();
                }
            }
        }
        return BM;
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

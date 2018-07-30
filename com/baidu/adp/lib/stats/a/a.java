package com.baidu.adp.lib.stats.a;
/* loaded from: classes.dex */
public class a {
    private static a BH = null;
    private long clientLogID = 0;

    public static a iV() {
        if (BH == null) {
            synchronized (a.class) {
                if (BH == null) {
                    BH = new a();
                }
            }
        }
        return BH;
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

package com.baidu.adp.lib.stats.a;
/* loaded from: classes.dex */
public class a {
    private static a qV = null;
    private long clientLogID = 0;

    public static a gF() {
        if (qV == null) {
            synchronized (a.class) {
                if (qV == null) {
                    qV = new a();
                }
            }
        }
        return qV;
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

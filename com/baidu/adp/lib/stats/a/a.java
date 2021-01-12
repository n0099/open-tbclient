package com.baidu.adp.lib.stats.a;
/* loaded from: classes.dex */
public class a {
    private static a Pv = null;
    private long clientLogID = 0;

    public static a ns() {
        if (Pv == null) {
            synchronized (a.class) {
                if (Pv == null) {
                    Pv = new a();
                }
            }
        }
        return Pv;
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

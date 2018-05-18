package com.baidu.adp.lib.stats.a;
/* loaded from: classes.dex */
public class a {
    private static a vE = null;
    private long clientLogID = 0;

    public static a gf() {
        if (vE == null) {
            synchronized (a.class) {
                if (vE == null) {
                    vE = new a();
                }
            }
        }
        return vE;
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

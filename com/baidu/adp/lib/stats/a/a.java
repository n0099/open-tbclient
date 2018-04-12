package com.baidu.adp.lib.stats.a;
/* loaded from: classes.dex */
public class a {
    private static a vF = null;
    private long clientLogID = 0;

    public static a gf() {
        if (vF == null) {
            synchronized (a.class) {
                if (vF == null) {
                    vF = new a();
                }
            }
        }
        return vF;
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

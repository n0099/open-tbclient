package com.baidu.adp.lib.stats.a;
/* loaded from: classes.dex */
public class a {
    private static a Nk = null;
    private long clientLogID = 0;

    public static a mm() {
        if (Nk == null) {
            synchronized (a.class) {
                if (Nk == null) {
                    Nk = new a();
                }
            }
        }
        return Nk;
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

package com.baidu.adp.lib.stats.a;
/* loaded from: classes.dex */
public class a {
    private static a Oi = null;
    private long clientLogID = 0;

    public static a nQ() {
        if (Oi == null) {
            synchronized (a.class) {
                if (Oi == null) {
                    Oi = new a();
                }
            }
        }
        return Oi;
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

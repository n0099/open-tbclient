package com.baidu.adp.lib.stats.a;
/* loaded from: classes.dex */
public class a {
    private static a xt = null;
    private long clientLogID = 0;

    public static a gA() {
        if (xt == null) {
            synchronized (a.class) {
                if (xt == null) {
                    xt = new a();
                }
            }
        }
        return xt;
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

package com.baidu.adp.lib.stats.a;
/* loaded from: classes.dex */
public class a {
    private static a alb = null;
    private long clientLogID = 0;

    public static a oa() {
        if (alb == null) {
            synchronized (a.class) {
                if (alb == null) {
                    alb = new a();
                }
            }
        }
        return alb;
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

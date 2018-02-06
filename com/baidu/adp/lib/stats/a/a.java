package com.baidu.adp.lib.stats.a;
/* loaded from: classes.dex */
public class a {
    private static a alh = null;
    private long clientLogID = 0;

    public static a oa() {
        if (alh == null) {
            synchronized (a.class) {
                if (alh == null) {
                    alh = new a();
                }
            }
        }
        return alh;
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

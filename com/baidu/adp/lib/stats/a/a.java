package com.baidu.adp.lib.stats.a;
/* loaded from: classes.dex */
public class a {
    private static a ti = null;
    private long clientLogID = 0;

    public static a hd() {
        if (ti == null) {
            synchronized (a.class) {
                if (ti == null) {
                    ti = new a();
                }
            }
        }
        return ti;
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

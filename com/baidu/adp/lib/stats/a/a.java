package com.baidu.adp.lib.stats.a;
/* loaded from: classes.dex */
public class a {
    private static a Cx = null;
    private long clientLogID = 0;

    public static a jj() {
        if (Cx == null) {
            synchronized (a.class) {
                if (Cx == null) {
                    Cx = new a();
                }
            }
        }
        return Cx;
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

package com.baidu.adp.lib.stats.a;
/* loaded from: classes.dex */
public class a {
    private static a xS = null;
    private long clientLogID = 0;

    public static a gv() {
        if (xS == null) {
            synchronized (a.class) {
                if (xS == null) {
                    xS = new a();
                }
            }
        }
        return xS;
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

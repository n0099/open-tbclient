package com.baidu.adp.lib.stats.a;
/* loaded from: classes.dex */
public class a {
    private static a wU = null;
    private long clientLogID = 0;

    public static a gz() {
        if (wU == null) {
            synchronized (a.class) {
                if (wU == null) {
                    wU = new a();
                }
            }
        }
        return wU;
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

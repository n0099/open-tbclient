package com.baidu.adp.lib.stats.a;
/* loaded from: classes.dex */
public class a {
    private static a yY = null;
    private long clientLogID = 0;

    public static a gI() {
        if (yY == null) {
            synchronized (a.class) {
                if (yY == null) {
                    yY = new a();
                }
            }
        }
        return yY;
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

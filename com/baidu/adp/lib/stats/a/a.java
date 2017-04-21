package com.baidu.adp.lib.stats.a;
/* loaded from: classes.dex */
public class a {
    private static a xw = null;
    private long clientLogID = 0;

    public static a gB() {
        if (xw == null) {
            synchronized (a.class) {
                if (xw == null) {
                    xw = new a();
                }
            }
        }
        return xw;
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

package com.baidu.adp.lib.stats.a;
/* loaded from: classes.dex */
public class a {
    private static a MH = null;
    private long clientLogID = 0;

    public static a lW() {
        if (MH == null) {
            synchronized (a.class) {
                if (MH == null) {
                    MH = new a();
                }
            }
        }
        return MH;
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

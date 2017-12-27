package com.baidu.adp.lib.stats.a;
/* loaded from: classes.dex */
public class a {
    private static a alf = null;
    private long clientLogID = 0;

    public static a nZ() {
        if (alf == null) {
            synchronized (a.class) {
                if (alf == null) {
                    alf = new a();
                }
            }
        }
        return alf;
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

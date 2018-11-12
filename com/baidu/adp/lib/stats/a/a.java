package com.baidu.adp.lib.stats.a;
/* loaded from: classes.dex */
public class a {
    private static a EP = null;
    private long clientLogID = 0;

    public static a kn() {
        if (EP == null) {
            synchronized (a.class) {
                if (EP == null) {
                    EP = new a();
                }
            }
        }
        return EP;
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

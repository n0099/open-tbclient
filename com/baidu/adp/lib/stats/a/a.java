package com.baidu.adp.lib.stats.a;
/* loaded from: classes.dex */
public class a {
    private static a ali = null;
    private long clientLogID = 0;

    public static a oa() {
        if (ali == null) {
            synchronized (a.class) {
                if (ali == null) {
                    ali = new a();
                }
            }
        }
        return ali;
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

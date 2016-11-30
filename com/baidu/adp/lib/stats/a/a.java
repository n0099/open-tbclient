package com.baidu.adp.lib.stats.a;
/* loaded from: classes.dex */
public class a {
    private static a qD = null;
    private long clientLogID = 0;

    public static a fC() {
        if (qD == null) {
            synchronized (a.class) {
                if (qD == null) {
                    qD = new a();
                }
            }
        }
        return qD;
    }

    public synchronized long eK() {
        if (this.clientLogID > 0) {
            this.clientLogID++;
        } else {
            this.clientLogID = System.currentTimeMillis();
        }
        return this.clientLogID;
    }
}

package com.baidu.adp.lib.stats.a;
/* loaded from: classes.dex */
public class a {
    private static a xd = null;
    private long clientLogID = 0;

    public static a ig() {
        if (xd == null) {
            synchronized (a.class) {
                if (xd == null) {
                    xd = new a();
                }
            }
        }
        return xd;
    }

    public synchronized long hn() {
        if (this.clientLogID > 0) {
            this.clientLogID++;
        } else {
            this.clientLogID = System.currentTimeMillis();
        }
        return this.clientLogID;
    }
}

package com.baidu.adp.lib.stats.a;
/* loaded from: classes.dex */
public class a {
    private static a xf = null;
    private long clientLogID = 0;

    public static a ig() {
        if (xf == null) {
            synchronized (a.class) {
                if (xf == null) {
                    xf = new a();
                }
            }
        }
        return xf;
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

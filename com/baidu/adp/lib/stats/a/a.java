package com.baidu.adp.lib.stats.a;
/* loaded from: classes.dex */
public class a {
    private static a wW = null;
    private long clientLogID = 0;

    public static a ib() {
        if (wW == null) {
            synchronized (a.class) {
                if (wW == null) {
                    wW = new a();
                }
            }
        }
        return wW;
    }

    public synchronized long hj() {
        if (this.clientLogID > 0) {
            this.clientLogID++;
        } else {
            this.clientLogID = System.currentTimeMillis();
        }
        return this.clientLogID;
    }
}

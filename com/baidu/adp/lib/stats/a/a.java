package com.baidu.adp.lib.stats.a;
/* loaded from: classes.dex */
public class a {
    private static a wX = null;
    private long clientLogID = 0;

    public static a ic() {
        if (wX == null) {
            synchronized (a.class) {
                if (wX == null) {
                    wX = new a();
                }
            }
        }
        return wX;
    }

    public synchronized long hk() {
        if (this.clientLogID > 0) {
            this.clientLogID++;
        } else {
            this.clientLogID = System.currentTimeMillis();
        }
        return this.clientLogID;
    }
}

package com.baidu.adp.lib.stats.a;
/* loaded from: classes.dex */
public class a {
    private static a wY = null;
    private long clientLogID = 0;

    public static a ie() {
        if (wY == null) {
            synchronized (a.class) {
                if (wY == null) {
                    wY = new a();
                }
            }
        }
        return wY;
    }

    public synchronized long hm() {
        if (this.clientLogID > 0) {
            this.clientLogID++;
        } else {
            this.clientLogID = System.currentTimeMillis();
        }
        return this.clientLogID;
    }
}

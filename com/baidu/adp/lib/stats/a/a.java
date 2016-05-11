package com.baidu.adp.lib.stats.a;
/* loaded from: classes.dex */
public class a {
    private static a nF = null;
    private long clientLogID = 0;

    public static a eH() {
        if (nF == null) {
            synchronized (a.class) {
                if (nF == null) {
                    nF = new a();
                }
            }
        }
        return nF;
    }

    public synchronized long dP() {
        if (this.clientLogID > 0) {
            this.clientLogID++;
        } else {
            this.clientLogID = System.currentTimeMillis();
        }
        return this.clientLogID;
    }
}

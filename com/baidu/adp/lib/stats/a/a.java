package com.baidu.adp.lib.stats.a;
/* loaded from: classes.dex */
public class a {
    private static a oh = null;
    private long clientLogID = 0;

    public static a eH() {
        if (oh == null) {
            synchronized (a.class) {
                if (oh == null) {
                    oh = new a();
                }
            }
        }
        return oh;
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

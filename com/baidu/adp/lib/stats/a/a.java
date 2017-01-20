package com.baidu.adp.lib.stats.a;
/* loaded from: classes.dex */
public class a {
    private static a qw = null;
    private long clientLogID = 0;

    public static a fA() {
        if (qw == null) {
            synchronized (a.class) {
                if (qw == null) {
                    qw = new a();
                }
            }
        }
        return qw;
    }

    public synchronized long eI() {
        if (this.clientLogID > 0) {
            this.clientLogID++;
        } else {
            this.clientLogID = System.currentTimeMillis();
        }
        return this.clientLogID;
    }
}

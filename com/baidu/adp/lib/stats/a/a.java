package com.baidu.adp.lib.stats.a;
/* loaded from: classes.dex */
public class a {
    private static a xo = null;
    private long clientLogID = 0;

    public static a iq() {
        if (xo == null) {
            synchronized (a.class) {
                if (xo == null) {
                    xo = new a();
                }
            }
        }
        return xo;
    }

    public synchronized long hv() {
        if (this.clientLogID > 0) {
            this.clientLogID++;
        } else {
            this.clientLogID = System.currentTimeMillis();
        }
        return this.clientLogID;
    }
}

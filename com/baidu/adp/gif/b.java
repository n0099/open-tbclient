package com.baidu.adp.gif;
/* loaded from: classes.dex */
public class b implements a {
    private static a dp;
    private int dq;
    private final g dr = new g();

    public b() {
        this.dq = 0;
        if (NSGif.ds) {
            this.dq = 0;
        } else {
            this.dq = 1;
        }
    }

    public static synchronized a bi() {
        a aVar;
        synchronized (b.class) {
            if (dp == null) {
                dp = new b();
            }
            aVar = dp;
        }
        return aVar;
    }

    @Override // com.baidu.adp.gif.a
    public com.baidu.adp.widget.a.a m(String str) {
        if (this.dq != 0) {
            return null;
        }
        try {
            return this.dr.m(str);
        } catch (Exception e) {
            return null;
        }
    }
}

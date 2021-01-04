package com.baidu.adp.framework.d;
/* loaded from: classes.dex */
public class a extends d {
    private static a JL = null;

    public static a kY() {
        if (JL == null) {
            synchronized (a.class) {
                if (JL == null) {
                    JL = new a();
                }
            }
        }
        return JL;
    }

    private a() {
    }
}

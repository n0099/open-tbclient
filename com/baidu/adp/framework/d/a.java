package com.baidu.adp.framework.d;
/* loaded from: classes.dex */
public class a extends d {
    private static a JJ = null;

    public static a kY() {
        if (JJ == null) {
            synchronized (a.class) {
                if (JJ == null) {
                    JJ = new a();
                }
            }
        }
        return JJ;
    }

    private a() {
    }
}

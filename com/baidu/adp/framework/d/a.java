package com.baidu.adp.framework.d;
/* loaded from: classes.dex */
public class a extends d {
    private static a JI = null;

    public static a kX() {
        if (JI == null) {
            synchronized (a.class) {
                if (JI == null) {
                    JI = new a();
                }
            }
        }
        return JI;
    }

    private a() {
    }
}

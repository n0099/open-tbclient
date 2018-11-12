package com.baidu.adp.framework.c;
/* loaded from: classes.dex */
public class a extends d {
    private static a yB = null;

    public static a hm() {
        if (yB == null) {
            synchronized (a.class) {
                if (yB == null) {
                    yB = new a();
                }
            }
        }
        return yB;
    }

    private a() {
    }
}

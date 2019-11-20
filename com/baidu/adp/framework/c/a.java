package com.baidu.adp.framework.c;
/* loaded from: classes.dex */
public class a extends d {
    private static a lT = null;

    public static a eG() {
        if (lT == null) {
            synchronized (a.class) {
                if (lT == null) {
                    lT = new a();
                }
            }
        }
        return lT;
    }

    private a() {
    }
}

package com.baidu.adp.framework.c;
/* loaded from: classes.dex */
public class a extends d {
    private static a aeS = null;

    public static a kV() {
        if (aeS == null) {
            synchronized (a.class) {
                if (aeS == null) {
                    aeS = new a();
                }
            }
        }
        return aeS;
    }

    private a() {
    }
}

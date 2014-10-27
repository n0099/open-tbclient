package com.baidu.adp.framework.c;
/* loaded from: classes.dex */
public class a extends d {
    private static a cY = null;

    public static a aU() {
        if (cY == null) {
            synchronized (a.class) {
                if (cY == null) {
                    cY = new a();
                }
            }
        }
        return cY;
    }

    private a() {
    }
}

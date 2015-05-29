package com.baidu.adp.framework.c;
/* loaded from: classes.dex */
public class a extends d {
    private static a qC = null;

    public static a eU() {
        if (qC == null) {
            synchronized (a.class) {
                if (qC == null) {
                    qC = new a();
                }
            }
        }
        return qC;
    }

    private a() {
    }
}

package com.baidu.adp.framework.c;
/* loaded from: classes.dex */
public class a extends d {
    private static a qU = null;

    public static a dr() {
        if (qU == null) {
            synchronized (a.class) {
                if (qU == null) {
                    qU = new a();
                }
            }
        }
        return qU;
    }

    private a() {
    }
}

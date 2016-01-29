package com.baidu.adp.framework.c;
/* loaded from: classes.dex */
public class a extends d {
    private static a qK = null;

    public static a eY() {
        if (qK == null) {
            synchronized (a.class) {
                if (qK == null) {
                    qK = new a();
                }
            }
        }
        return qK;
    }

    private a() {
    }
}

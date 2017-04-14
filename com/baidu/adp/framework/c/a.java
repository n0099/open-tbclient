package com.baidu.adp.framework.c;
/* loaded from: classes.dex */
public class a extends d {
    private static a qP = null;

    public static a dq() {
        if (qP == null) {
            synchronized (a.class) {
                if (qP == null) {
                    qP = new a();
                }
            }
        }
        return qP;
    }

    private a() {
    }
}

package com.baidu.adp.framework.c;
/* loaded from: classes.dex */
public class a extends d {
    private static a qy = null;

    public static a eQ() {
        if (qy == null) {
            synchronized (a.class) {
                if (qy == null) {
                    qy = new a();
                }
            }
        }
        return qy;
    }

    private a() {
    }
}

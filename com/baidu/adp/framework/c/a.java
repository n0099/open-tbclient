package com.baidu.adp.framework.c;
/* loaded from: classes.dex */
public class a extends d {
    private static a qB = null;

    public static a eS() {
        if (qB == null) {
            synchronized (a.class) {
                if (qB == null) {
                    qB = new a();
                }
            }
        }
        return qB;
    }

    private a() {
    }
}

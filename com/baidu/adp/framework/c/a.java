package com.baidu.adp.framework.c;
/* loaded from: classes.dex */
public class a extends d {
    private static a qE = null;

    public static a eS() {
        if (qE == null) {
            synchronized (a.class) {
                if (qE == null) {
                    qE = new a();
                }
            }
        }
        return qE;
    }

    private a() {
    }
}

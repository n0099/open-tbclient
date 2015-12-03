package com.baidu.adp.framework.c;
/* loaded from: classes.dex */
public class a extends d {
    private static a qD = null;

    public static a eS() {
        if (qD == null) {
            synchronized (a.class) {
                if (qD == null) {
                    qD = new a();
                }
            }
        }
        return qD;
    }

    private a() {
    }
}

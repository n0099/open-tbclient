package com.baidu.adp.framework.c;
/* loaded from: classes.dex */
public class a extends d {
    private static a aeM = null;

    public static a kV() {
        if (aeM == null) {
            synchronized (a.class) {
                if (aeM == null) {
                    aeM = new a();
                }
            }
        }
        return aeM;
    }

    private a() {
    }
}

package com.baidu.adp.framework.d;
/* loaded from: classes.dex */
public class a extends d {
    private static a HL = null;

    public static a jI() {
        if (HL == null) {
            synchronized (a.class) {
                if (HL == null) {
                    HL = new a();
                }
            }
        }
        return HL;
    }

    private a() {
    }
}

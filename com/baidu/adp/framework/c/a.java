package com.baidu.adp.framework.c;
/* loaded from: classes.dex */
public class a extends d {
    private static a HA = null;

    public static a jG() {
        if (HA == null) {
            synchronized (a.class) {
                if (HA == null) {
                    HA = new a();
                }
            }
        }
        return HA;
    }

    private a() {
    }
}

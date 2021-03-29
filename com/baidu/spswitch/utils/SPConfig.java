package com.baidu.spswitch.utils;
/* loaded from: classes2.dex */
public class SPConfig {
    public static boolean sDebug = false;

    public static void init(boolean z) {
        sDebug = z;
    }

    public static boolean isDebug() {
        return sDebug;
    }
}

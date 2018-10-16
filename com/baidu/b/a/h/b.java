package com.baidu.b.a.h;
/* loaded from: classes2.dex */
public class b {
    private static boolean sDebug = false;
    private static boolean sIsMainProcess = true;

    public static boolean isDebug() {
        return sDebug;
    }

    public static void ax(boolean z) {
        sIsMainProcess = z;
    }

    public static boolean isMainProcess() {
        return sIsMainProcess;
    }
}

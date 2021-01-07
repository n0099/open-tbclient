package com.baidu.crashpad;

import android.content.Context;
import android.content.pm.ApplicationInfo;
/* loaded from: classes4.dex */
public class ZwDebugExtra {
    private static boolean debugModel;

    public static boolean debugModel() {
        return debugModel;
    }

    public static synchronized void init(Context context) {
        synchronized (ZwDebugExtra.class) {
            try {
                ApplicationInfo applicationInfo = context.getApplicationInfo();
                if (applicationInfo != null) {
                    debugModel = (applicationInfo.flags & 2) != 0;
                }
            } catch (Exception e) {
            }
        }
    }

    public static void crashIntentionally(int i) {
        if (debugModel) {
            ZwCrashpad.crashIntentionally(i);
        }
    }

    public static void setCrashKeyValue(String str, String str2) {
        ZwCrashpad.setCrashKeyValue(str, str2);
    }

    public static void clearCrashKey(String str) {
        ZwCrashpad.clearCrashKey(str);
    }
}

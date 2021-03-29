package com.baidu.crashpad;

import android.content.Context;
import android.content.pm.ApplicationInfo;
/* loaded from: classes.dex */
public class ZwDebugExtra {
    public static boolean debugModel;

    public static void clearCrashKey(String str) {
        ZwCrashpad.clearCrashKey(str);
    }

    public static void crashIntentionally(int i) {
        if (debugModel) {
            ZwCrashpad.crashIntentionally(i);
        }
    }

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
            } catch (Exception unused) {
            }
        }
    }

    public static void setCrashKeyValue(String str, String str2) {
        ZwCrashpad.setCrashKeyValue(str, str2);
    }
}

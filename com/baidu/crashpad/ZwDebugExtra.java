package com.baidu.crashpad;

import android.content.Context;
import android.content.pm.ApplicationInfo;
/* loaded from: classes11.dex */
public class ZwDebugExtra {
    private static boolean a;

    public static void clearCrashKey(String str) {
        ZwCrashpad.clearCrashKey(str);
    }

    public static void crashIntentionally(int i) {
        if (a) {
            ZwCrashpad.crashIntentionally(i);
        }
    }

    public static boolean debugModel() {
        return a;
    }

    public static synchronized void init(Context context) {
        synchronized (ZwDebugExtra.class) {
            try {
                ApplicationInfo applicationInfo = context.getApplicationInfo();
                if (applicationInfo != null) {
                    a = (applicationInfo.flags & 2) != 0;
                }
            } catch (Exception e) {
                com.a.a.a.a.a.a.a.a(e);
            }
        }
    }

    public static void setCrashKeyValue(String str, String str2) {
        ZwCrashpad.setCrashKeyValue(str, str2);
    }
}

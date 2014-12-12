package com.baidu.megapp.ma;

import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
public class Util {
    public static void remapStartServiceIntent(String str, Intent intent) {
    }

    public static void remapStartActivityIntent(String str, Intent intent) {
    }

    public static void remapReceiverIntent(String str, Intent intent) {
    }

    public static int getHostResourcesId(Context context, String str, String str2, String str3) {
        if (context != null) {
            return context.getResources().getIdentifier(str2, str3, context.getPackageName());
        }
        return 0;
    }
}

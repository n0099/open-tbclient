package com.baidu.megapp.ma;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes2.dex */
public class Util {
    public static Intent createActivityIntent(Context context, String str, String str2) {
        Intent intent = new Intent();
        intent.setClassName(context.getPackageName(), str2);
        return intent;
    }

    public static int getHostResourcesId(Context context, String str, String str2, String str3) {
        if (context != null) {
            return context.getResources().getIdentifier(str2, str3, context.getPackageName());
        }
        return 0;
    }

    public static String getTargetPackageName(Context context) {
        return context.getPackageName();
    }

    public static void quitApp(String str) {
    }

    public static void remapReceiverIntent(String str, Intent intent) {
    }

    public static void remapStartActivityIntent(String str, Intent intent) {
    }

    public static void remapStartServiceIntent(String str, Intent intent) {
    }

    public MAActivity getMAActivityByProxy(Activity activity) {
        if (activity instanceof MAActivity) {
            return (MAActivity) activity;
        }
        return null;
    }
}

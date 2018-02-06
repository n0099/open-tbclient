package com.baidu.ar.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
/* loaded from: classes3.dex */
public class f {
    public static String a(Context context) {
        if (context != null) {
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                return applicationInfo.metaData == null ? "" : applicationInfo.metaData.getString("channelName");
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public static boolean a(String str) {
        return str == null || str.isEmpty();
    }

    public static boolean b(Context context) {
        String a = a(context);
        return !a(a) && a.equals("NUOMI");
    }

    public static boolean c(Context context) {
        String a = a(context);
        return !a(a) && a.equals("SHOUZHU");
    }

    public static boolean d(Context context) {
        String a = a(context);
        return a(a) || a.equals("BAIDU");
    }
}

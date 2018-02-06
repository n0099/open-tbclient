package com.baidu.ar.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
/* loaded from: classes3.dex */
public class c {
    public static int a() {
        return 15;
    }

    public static String a(Context context) {
        String str = null;
        if (context == null) {
            return null;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            StringBuilder sb = new StringBuilder(context.getApplicationContext().getPackageName());
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(context.getApplicationContext().getPackageName(), 0);
                if (packageInfo != null) {
                    String str2 = packageInfo.versionName;
                    if (!TextUtils.isEmpty(str2)) {
                        sb.append("_");
                        sb.append(str2);
                        b.a("appId = " + sb.toString());
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
            str = sb.toString();
            return str;
        } catch (NullPointerException e2) {
            e2.printStackTrace();
            return str;
        }
    }

    public static String b() {
        return "6.0";
    }
}

package com.baidu.ar.h;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class c {
    public static String xU = "pro";
    public static String xV = "101";

    public static int getVersionCode() {
        return 5010;
    }

    public static String getVersionName() {
        return "5.1.0";
    }

    public static String gx() {
        return xU;
    }

    public static String gy() {
        return xV;
    }

    public static String s(Context context) {
        if (context == null) {
            return null;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            StringBuilder sb = new StringBuilder(context.getApplicationContext().getPackageName());
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(context.getApplicationContext().getPackageName(), 0);
                if (packageInfo != null) {
                    String str = packageInfo.versionName;
                    if (!TextUtils.isEmpty(str)) {
                        sb.append("_");
                        sb.append(str);
                        b.aQ("appId = " + sb.toString());
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
            return sb.toString();
        } catch (NullPointerException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}

package com.baidu.ar.h;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
/* loaded from: classes6.dex */
public class c {
    private static String xU = "pro";
    private static String xV = "101";

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
                        sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                        sb.append(str2);
                        b.aQ("appId = " + sb.toString());
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
}

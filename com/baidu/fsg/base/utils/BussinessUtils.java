package com.baidu.fsg.base.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
/* loaded from: classes3.dex */
public final class BussinessUtils {
    public static String getUA(Context context) {
        PackageInfo packageInfo;
        String str = "";
        String str2 = "";
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0)) != null) {
                str = packageInfo.versionName;
                str2 = packageInfo.versionCode + "";
            }
        } catch (Exception e) {
            if (str == null) {
                str = "";
            }
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        StringBuilder sb = new StringBuilder();
        sb.append(ChannelUtils.getSDKVersion());
        sb.append('_');
        sb.append(displayMetrics.widthPixels);
        sb.append('_');
        sb.append(displayMetrics.heightPixels);
        sb.append('_');
        sb.append((Build.MODEL + '-' + Build.DEVICE).replace(' ', '-').replace('_', '-'));
        sb.append('_');
        sb.append(Build.VERSION.SDK);
        sb.append('_');
        String str3 = Build.VERSION.RELEASE;
        if (!TextUtils.isEmpty(str3)) {
            str3 = str3.replace(' ', '-').replace('_', '-');
        }
        sb.append(str3);
        sb.append('_');
        sb.append(str);
        sb.append('_');
        sb.append(str2);
        return sb.toString();
    }
}

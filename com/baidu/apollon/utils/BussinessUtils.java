package com.baidu.apollon.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
/* loaded from: classes.dex */
public final class BussinessUtils {
    /* JADX WARN: Code restructure failed: missing block: B:12:0x002a, code lost:
        if (r2 != null) goto L11;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0091  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getUA(Context context) {
        String str;
        String str2;
        String str3;
        PackageManager packageManager;
        PackageInfo packageInfo;
        String str4 = "";
        try {
            packageManager = context.getPackageManager();
        } catch (Exception unused) {
            str = "";
        }
        if (packageManager != null && (packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0)) != null) {
            str = packageInfo.versionName;
            try {
                str4 = packageInfo.versionCode + "";
            } catch (Exception unused2) {
            }
            str2 = str4;
            str4 = str;
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
            str3 = Build.VERSION.RELEASE;
            if (!TextUtils.isEmpty(str3)) {
                str3 = str3.replace(' ', '-').replace('_', '-');
            }
            sb.append(str3);
            sb.append('_');
            sb.append(str4);
            sb.append('_');
            sb.append(str2);
            return sb.toString();
        }
        str2 = "";
        DisplayMetrics displayMetrics2 = context.getResources().getDisplayMetrics();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(ChannelUtils.getSDKVersion());
        sb2.append('_');
        sb2.append(displayMetrics2.widthPixels);
        sb2.append('_');
        sb2.append(displayMetrics2.heightPixels);
        sb2.append('_');
        sb2.append((Build.MODEL + '-' + Build.DEVICE).replace(' ', '-').replace('_', '-'));
        sb2.append('_');
        sb2.append(Build.VERSION.SDK);
        sb2.append('_');
        str3 = Build.VERSION.RELEASE;
        if (!TextUtils.isEmpty(str3)) {
        }
        sb2.append(str3);
        sb2.append('_');
        sb2.append(str4);
        sb2.append('_');
        sb2.append(str2);
        return sb2.toString();
    }
}

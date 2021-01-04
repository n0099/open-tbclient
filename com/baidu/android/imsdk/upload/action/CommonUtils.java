package com.baidu.android.imsdk.upload.action;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
/* loaded from: classes3.dex */
public class CommonUtils {
    public static IMPushPb.Common getIMCommon(Context context, String str) {
        return IMPushPb.Common.newBuilder().setDeviceId(IMPushPb.DeviceID.newBuilder().setCuid(str).build()).setTimestamp(-1L).setUserTimestamp(System.currentTimeMillis()).setTerminalInfo(getTerminalInfo(context)).setNetInfo(getNetInfo(context)).setAppInfo(IMPushPb.AppInfo.newBuilder().setAppName(context.getPackageName()).setAppVersion(TextUtils.isEmpty(getAppVersionName(context)) ? "" : getAppVersionName(context)).setAppChannel("").build()).build();
    }

    private static IMPushPb.TerminalInfo getTerminalInfo(Context context) {
        int i;
        int i2;
        int i3;
        int i4;
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
                i4 = displayMetrics.widthPixels;
                i2 = displayMetrics.heightPixels;
            } else {
                i2 = displayMetrics.widthPixels;
                i4 = displayMetrics.heightPixels;
            }
            i = displayMetrics.densityDpi;
            i3 = i4;
        } else {
            i = 0;
            i2 = 0;
            i3 = 0;
        }
        return IMPushPb.TerminalInfo.newBuilder().setOs(IMPushPb.OSType.ANDROID).setOsVersion(Build.VERSION.RELEASE).setManufacturer(Build.MANUFACTURER).setTerminalType(Build.MODEL).setResolutionH(i3).setResolutionV(i2).setPpi(i).build();
    }

    private static IMPushPb.NetInfo getNetInfo(Context context) {
        String str;
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        String str2 = "";
        if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
            str2 = "" + activeNetworkInfo.getTypeName();
            str = "" + activeNetworkInfo.getExtraInfo();
        } else {
            str = "";
        }
        return IMPushPb.NetInfo.newBuilder().setNetType(str2).setNetApn(str).build();
    }

    public static String getAppVersionName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("Utils", "getAppVersionName NameNotFoundException", e);
            return "";
        }
    }
}

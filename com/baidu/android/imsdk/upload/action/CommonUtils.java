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
        int i5 = 0;
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
                i4 = displayMetrics.widthPixels;
                i3 = displayMetrics.heightPixels;
            } else {
                i3 = displayMetrics.widthPixels;
                i4 = displayMetrics.heightPixels;
            }
            int i6 = displayMetrics.densityDpi;
            i2 = i4;
            i5 = i3;
            i = i6;
        } else {
            i = 0;
            i2 = 0;
        }
        return IMPushPb.TerminalInfo.newBuilder().setOs(IMPushPb.OSType.ANDROID).setOsVersion(Build.VERSION.RELEASE).setManufacturer(Build.MANUFACTURER).setTerminalType(Build.MODEL).setResolutionH(i2).setResolutionV(i5).setPpi(i).build();
    }

    private static IMPushPb.NetInfo getNetInfo(Context context) {
        String str;
        String str2;
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
            String str3 = "" + activeNetworkInfo.getTypeName();
            str = "" + activeNetworkInfo.getExtraInfo();
            str2 = str3;
        } else {
            str = "";
            str2 = "";
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

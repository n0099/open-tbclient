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
import com.baidu.down.utils.Utils;
/* loaded from: classes.dex */
public class CommonUtils {
    public static String getAppVersionName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            Log.e(Utils.TAG, "getAppVersionName NameNotFoundException", e2);
            return "";
        }
    }

    public static IMPushPb.Common getIMCommon(Context context, String str) {
        return IMPushPb.Common.newBuilder().setDeviceId(IMPushPb.DeviceID.newBuilder().setCuid(str).build()).setTimestamp(-1L).setUserTimestamp(System.currentTimeMillis()).setTerminalInfo(getTerminalInfo(context)).setNetInfo(getNetInfo(context)).setAppInfo(IMPushPb.AppInfo.newBuilder().setAppName(context.getPackageName()).setAppVersion(TextUtils.isEmpty(getAppVersionName(context)) ? "" : getAppVersionName(context)).setAppChannel("").build()).build();
    }

    public static IMPushPb.NetInfo getNetInfo(Context context) {
        String str;
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        String str2 = "";
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
            str = "";
        } else {
            String str3 = "" + activeNetworkInfo.getTypeName();
            str = "" + activeNetworkInfo.getExtraInfo();
            str2 = str3;
        }
        return IMPushPb.NetInfo.newBuilder().setNetType(str2).setNetApn(str).build();
    }

    public static IMPushPb.TerminalInfo getTerminalInfo(Context context) {
        int i;
        int i2;
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        int i3 = 0;
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            i = displayMetrics.widthPixels;
            i3 = displayMetrics.heightPixels;
            if (i > i3) {
                i3 = i;
                i = i3;
            }
            i2 = displayMetrics.densityDpi;
        } else {
            i = 0;
            i2 = 0;
        }
        return IMPushPb.TerminalInfo.newBuilder().setOs(IMPushPb.OSType.ANDROID).setOsVersion(Build.VERSION.RELEASE).setManufacturer(Build.MANUFACTURER).setTerminalType(Build.MODEL).setResolutionH(i3).setResolutionV(i).setPpi(i2).build();
    }
}

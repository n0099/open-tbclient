package com.baidu.android.util.android;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.heytap.mcssdk.PushManager;
/* loaded from: classes.dex */
public class VersionUtils {
    public static final String TAG = "VersionUtils";
    public static String sBoxVersionCode;
    public static String sBoxVersionName;

    @Deprecated
    public static String getVersionCode(Context context) {
        return getVersionCode();
    }

    @Deprecated
    public static String getVersionName() {
        return getVersionName(AppRuntime.getAppContext());
    }

    @Deprecated
    public static String readFourDotVersionName() {
        Bundle bundle;
        Context appContext = AppRuntime.getAppContext();
        try {
            ApplicationInfo applicationInfo = appContext.getPackageManager().getApplicationInfo(appContext.getPackageName(), 128);
            return (applicationInfo == null || (bundle = applicationInfo.metaData) == null) ? "" : bundle.getString(PushManager.APP_VERSION_NAME);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String getVersionCode() {
        Context appContext = AppRuntime.getAppContext();
        if (TextUtils.isEmpty(sBoxVersionCode)) {
            try {
                PackageInfo packageInfo = appContext.getPackageManager().getPackageInfo(appContext.getPackageName(), 0);
                sBoxVersionCode = packageInfo.versionCode + "";
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return sBoxVersionCode;
    }

    public static String getVersionName(Context context) {
        Context appContext = AppRuntime.getAppContext();
        if (TextUtils.isEmpty(sBoxVersionName)) {
            try {
                PackageInfo packageInfo = appContext.getPackageManager().getPackageInfo(appContext.getPackageName(), 0);
                sBoxVersionName = packageInfo.versionName + "";
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return sBoxVersionName;
    }
}

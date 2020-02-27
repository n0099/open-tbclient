package com.baidu.android.util.android;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes13.dex */
public class VersionUtils {
    private static final String TAG = "VersionUtils";
    private static String sBoxVersionCode = null;
    private static String sBoxVersionName = null;

    public static String getVersionCode(Context context) {
        Context appContext = AppRuntime.getAppContext();
        if (TextUtils.isEmpty(sBoxVersionCode)) {
            try {
                sBoxVersionCode = appContext.getPackageManager().getPackageInfo(appContext.getPackageName(), 0).versionCode + "";
            } catch (PackageManager.NameNotFoundException e) {
            }
        }
        return sBoxVersionCode;
    }

    public static String getVersionName() {
        return getVersionName(AppRuntime.getAppContext());
    }

    public static String getVersionName(Context context) {
        Context appContext = AppRuntime.getAppContext();
        if (TextUtils.isEmpty(sBoxVersionName)) {
            try {
                sBoxVersionName = appContext.getPackageManager().getPackageInfo(appContext.getPackageName(), 0).versionName + "";
            } catch (PackageManager.NameNotFoundException e) {
            }
        }
        return sBoxVersionName;
    }

    public static String readFourDotVersionName() {
        Bundle bundle;
        Context appContext = AppRuntime.getAppContext();
        try {
            ApplicationInfo applicationInfo = appContext.getPackageManager().getApplicationInfo(appContext.getPackageName(), 128);
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
                return "";
            }
            return bundle.getString("versionName");
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }
}

package com.baidu.swan.d;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.baidu.android.util.devices.NetWorkUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes11.dex */
public class a {
    public static String getOS() {
        return "Android";
    }

    public static int awj() {
        DisplayMetrics displayMetrics = getDisplayMetrics();
        if (displayMetrics != null) {
            return displayMetrics.widthPixels;
        }
        return 0;
    }

    public static int awk() {
        DisplayMetrics displayMetrics = getDisplayMetrics();
        if (displayMetrics != null) {
            return displayMetrics.heightPixels;
        }
        return 0;
    }

    public static int getDensityDpi() {
        DisplayMetrics displayMetrics = getDisplayMetrics();
        if (displayMetrics != null) {
            return displayMetrics.densityDpi;
        }
        return 0;
    }

    public static String getOsVersion() {
        String str = Build.VERSION.RELEASE;
        if (TextUtils.isEmpty(str)) {
            return "0.0";
        }
        return str.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
    }

    private static DisplayMetrics getDisplayMetrics() {
        Context appContext = AppRuntime.getAppContext();
        if (appContext == null) {
            return null;
        }
        return appContext.getResources().getDisplayMetrics();
    }

    public static String getNetworkInfo() {
        ConnectivityManager connectivityManager = (ConnectivityManager) AppRuntime.getAppContext().getSystemService("connectivity");
        if (connectivityManager == null) {
            return NetWorkUtils.NETWORK_TYPE_CELL_UN_CONNECTED;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return NetWorkUtils.NETWORK_TYPE_CELL_UN_CONNECTED;
        }
        if (activeNetworkInfo.getType() == 1) {
            return "WiFi";
        }
        if (activeNetworkInfo.getType() == 0) {
            switch (activeNetworkInfo.getSubtype()) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    return "2G";
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    return "3G";
                case 13:
                    return "4G";
                default:
                    return "unknown";
            }
        }
        return "unknown";
    }
}

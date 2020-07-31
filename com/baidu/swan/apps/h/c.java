package com.baidu.swan.apps.h;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.fsg.base.statistics.j;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.aq.ai;
import com.baidu.swan.apps.aq.al;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.webkit.internal.ETAG;
import com.xiaomi.mipush.sdk.Constants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
/* loaded from: classes7.dex */
public class c {
    private static final String[] bWC = {"https://mbd.baidu.com", "https://ossapi.baidu.com", "https://ext.baidu.com"};

    public static boolean jc(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (String str2 : bWC) {
            if (str.startsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    public static String processCommonParams(String str) {
        return addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(str, "uid", Xq()), j.c, Xr()), "ut", Xp()), "osbranch", Xt()), "pkgname", getPkgName()), "network", Xs()), "appname", getAppName()), "hostname", getAppName()), "swan_sdk_version", Xx()), "mnpunion", "0");
    }

    public static String Xp() {
        return df(getDeviceInfo());
    }

    public static String Xq() {
        return df(getUid());
    }

    public static String Xr() {
        return df(sY());
    }

    public static String Xs() {
        return Xz() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + Xy();
    }

    public static String Xt() {
        return "a0";
    }

    public static String getUid() {
        return com.baidu.swan.apps.t.a.aho().bf(AppRuntime.getAppContext());
    }

    public static String sY() {
        Context appContext = AppRuntime.getAppContext();
        int displayWidth = ai.getDisplayWidth(appContext);
        int displayHeight = ai.getDisplayHeight(appContext);
        int densityDpi = ai.getDensityDpi(appContext);
        String Xu = Xu();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(displayWidth);
        stringBuffer.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
        stringBuffer.append(displayHeight);
        stringBuffer.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
        stringBuffer.append(Xu);
        stringBuffer.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
        stringBuffer.append(al.getVersionName());
        stringBuffer.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
        stringBuffer.append(densityDpi);
        return stringBuffer.toString();
    }

    public static String Xu() {
        return "android";
    }

    public static String getPkgName() {
        return AppRuntime.getApplication().getPackageName();
    }

    public static String getDeviceInfo() {
        String deviceModel = getDeviceModel();
        String Xw = Xw();
        int i = Build.VERSION.SDK_INT;
        return deviceModel + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + Xw + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + i + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + Xv();
    }

    public static String Xv() {
        String str = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str)) {
            return "NUL";
        }
        return str.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
    }

    public static String Xw() {
        String str = Build.VERSION.RELEASE;
        if (TextUtils.isEmpty(str)) {
            return "0.0";
        }
        return str.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
    }

    public static String getDeviceModel() {
        String str = Build.MODEL;
        if (TextUtils.isEmpty(str)) {
            return "NUL";
        }
        return str.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
    }

    public static String addParam(String str, String str2, String str3) {
        StringBuilder sb;
        StringBuilder sb2;
        String str4 = null;
        if (!TextUtils.isEmpty(str)) {
            String str5 = str2 + ETAG.EQUAL;
            int indexOf = str.indexOf("?");
            if (indexOf < 0) {
                int indexOf2 = str.indexOf("#");
                if (indexOf2 < 0) {
                    sb2 = new StringBuilder(str);
                } else {
                    str4 = str.substring(indexOf2);
                    sb2 = new StringBuilder(str.substring(0, indexOf2));
                }
                sb2.append("?").append(str5).append(str3);
                if (str4 != null) {
                    sb2.append(str4);
                }
                return sb2.toString();
            } else if (str.indexOf(ETAG.ITEM_SEPARATOR + str5, indexOf) < 0 && str.indexOf("?" + str5, indexOf) < 0) {
                int indexOf3 = str.indexOf("#");
                if (indexOf3 < 0) {
                    sb = new StringBuilder(str);
                } else {
                    str4 = str.substring(indexOf3);
                    str = str.substring(0, indexOf3);
                    sb = new StringBuilder(str);
                }
                if (!str.endsWith(ETAG.ITEM_SEPARATOR) && !str.endsWith("?")) {
                    sb.append(ETAG.ITEM_SEPARATOR);
                }
                sb.append(str5).append(str3);
                if (str4 != null) {
                    sb.append(str4);
                }
                return sb.toString();
            } else {
                return str;
            }
        }
        return str;
    }

    public static String df(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return str;
        }
    }

    private static String Xx() {
        return com.baidu.swan.apps.c.getVersion();
    }

    private static String getAppName() {
        return com.baidu.swan.apps.t.a.ahU().getHostName();
    }

    private static int Xy() {
        NetworkInfo activeNetworkInfo = SwanAppNetworkUtils.getActiveNetworkInfo(com.baidu.swan.apps.t.a.ahj());
        if (activeNetworkInfo == null) {
            return 0;
        }
        return activeNetworkInfo.getSubtype();
    }

    private static int Xz() {
        NetworkInfo networkInfo;
        String str = null;
        try {
            networkInfo = ((ConnectivityManager) com.baidu.swan.apps.t.a.ahj().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (NullPointerException e) {
            networkInfo = null;
        }
        if (networkInfo != null) {
            if ("wifi".equals(networkInfo.getTypeName().toLowerCase())) {
                str = "WIFI";
            } else {
                str = networkInfo.getExtraInfo();
            }
        }
        if (str == null) {
            return 5;
        }
        String upperCase = str.toUpperCase();
        if ("WIFI".equals(upperCase)) {
            return 1;
        }
        if ("3GNET".equals(upperCase)) {
            return 21;
        }
        if ("3GWAP".equals(upperCase)) {
            return 22;
        }
        if ("CMNET".equals(upperCase)) {
            return 31;
        }
        if ("UNINET".equals(upperCase)) {
            return 32;
        }
        if ("CTNET".equals(upperCase)) {
            return 33;
        }
        if ("CMWAP".equals(upperCase)) {
            return 41;
        }
        if ("UNIWAP".equals(upperCase)) {
            return 42;
        }
        if (!"CTWAP".equals(upperCase)) {
            return 5;
        }
        return 43;
    }
}

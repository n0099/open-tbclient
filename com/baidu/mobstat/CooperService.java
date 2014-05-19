package com.baidu.mobstat;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import java.util.Date;
import java.util.HashMap;
import java.util.regex.Pattern;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class CooperService extends BasicStoreToolsBase {
    private static b a = new b();
    private static JSONObject b = new JSONObject();
    private static String c = "activehead";
    private static HashMap<String, Object> d = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b a() {
        return a;
    }

    private static String a(Context context) {
        String g = y.g(context);
        return g != null ? g.replaceAll(":", "") : g;
    }

    private static String a(String str, Context context) {
        if (str == null) {
            return null;
        }
        if (str.equals("000000000000000")) {
            String a2 = a(context);
            com.baidu.mobstat.a.e.a("statsdk", "imei=null,mac=" + a2);
            return a2;
        }
        return str;
    }

    public static boolean checkCellLocationSetting(Context context) {
        String a2 = y.a(context, "BaiduMobAd_CELL_LOCATION");
        return a2 == null || !a2.toLowerCase().equals("false");
    }

    public static boolean checkGPSLocationSetting(Context context) {
        String a2 = y.a(context, "BaiduMobAd_GPS_LOCATION");
        return a2 == null || !a2.toLowerCase().equals("false");
    }

    public static boolean checkWifiLocationSetting(Context context) {
        String a2 = y.a(context, "BaiduMobAd_WIFI_LOCATION");
        return a2 == null || !a2.toLowerCase().equals("false");
    }

    public static String getAppChannel(Context context) {
        try {
            if (a.j == null || a.j.equals("")) {
                boolean appChannelWithCode = BasicStoreTools.getInstance().getAppChannelWithCode(context);
                if (appChannelWithCode) {
                    a.j = BasicStoreTools.getInstance().getAppChannelWithPreference(context);
                }
                if (!appChannelWithCode || a.j == null || a.j.equals("")) {
                    a.j = y.a(context, "BaiduMobAd_CHANNEL");
                }
            }
        } catch (Exception e) {
            com.baidu.mobstat.a.e.a(e);
        }
        return a.j;
    }

    public static String getAppKey(Context context) {
        if (a.c == null) {
            a.c = y.a(context, "BaiduMobAd_STAT_ID");
        }
        return a.c;
    }

    public static int getAppVersionCode(Context context) {
        if (a.e == -1) {
            a.e = y.c(context);
        }
        return a.e;
    }

    public static String getAppVersionName(Context context) {
        if (a.f == null || "".equals(a.f)) {
            a.f = y.d(context);
        }
        return a.f;
    }

    public static String getCUID(Context context, boolean z) {
        if (a.d == null) {
            a.d = BasicStoreTools.getInstance().getGenerateDeviceCUID(context);
            if (a.d == null || "".equalsIgnoreCase(a.d)) {
                try {
                    a.d = com.baidu.a.a.a.b.a.a(context);
                    a.d = Pattern.compile("\\s*|\t|\r|\n").matcher(a.d).replaceAll("");
                    a.d = com.baidu.mobstat.a.d.a(com.baidu.mobstat.a.a.a("h9YLQoINGWyOBYYk", "h9YLQoINGWyOBYYk", a.d.getBytes()), "utf-8");
                    com.baidu.mobstat.a.e.a("sdkstat", "加密=mHeadObject.cuid=" + a.d);
                    BasicStoreTools.getInstance().setGenerateDeviceCUID(context, a.d);
                } catch (Exception e) {
                    com.baidu.mobstat.a.e.c("sdkstat", e.getMessage());
                }
            }
        }
        if (z) {
            return a.d;
        }
        try {
            if (a.d != null) {
                return new String(com.baidu.mobstat.a.a.b("h9YLQoINGWyOBYYk", "h9YLQoINGWyOBYYk", com.baidu.mobstat.a.d.a(a.d.getBytes())));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return null;
    }

    public static String getDeviceId(TelephonyManager telephonyManager, Context context) {
        String str;
        if (telephonyManager == null) {
            return a.g;
        }
        String str2 = a.g;
        if (str2 == null || str2.equals("")) {
            try {
                str2 = Pattern.compile("\\s*|\t|\r|\n").matcher(telephonyManager.getDeviceId()).replaceAll("");
                str = a(str2, context);
            } catch (Exception e) {
                com.baidu.mobstat.a.e.a(e);
                str = str2;
            }
            if (str == null) {
                str = a(context);
            }
            if (str == null || str.equals("000000000000000")) {
                str = BasicStoreTools.getInstance().getGenerateDeviceId(context);
            }
            if (str == null || str.equals("000000000000000")) {
                str = "hol" + (new Date().getTime() + "").hashCode() + "mes";
                BasicStoreTools.getInstance().setGenerateDeviceId(context, str);
                com.baidu.mobstat.a.e.a("statsdk", "设备id为空，系统生成id =" + str);
            }
            a.g = str;
            a.g = getSecretValue(a.g);
            com.baidu.mobstat.a.e.a("sdkstat", "加密=mHeadObject.device_id=" + a.g);
        }
        try {
            com.baidu.mobstat.a.e.a("sdkstat", "device_id=" + new String(com.baidu.mobstat.a.a.b("h9YLQoINGWyOBYYk", "h9YLQoINGWyOBYYk", com.baidu.mobstat.a.d.a(a.g.getBytes()))));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return a.g;
    }

    public static String getLinkedWay(Context context) {
        if (a.p == null || "".equals(a.p)) {
            a.p = y.i(context);
        }
        return a.p;
    }

    public static String getMTJSDKVersion() {
        return "3.4.1.1";
    }

    public static String getMacID(Context context) {
        if (a.q == null || "".equals(a.q)) {
            String appDeviceMac = BasicStoreTools.getInstance().getAppDeviceMac(context);
            if (appDeviceMac == null) {
                String a2 = a(context);
                if (a2 != null) {
                    a.q = getSecretValue(a2);
                    com.baidu.mobstat.a.e.a("sdkstat", "加密=mHeadObject.mHeadObject.mac_addr=" + a.q);
                    if (a.q != "") {
                        BasicStoreTools.getInstance().setAppDeviceMac(context, a.q);
                    }
                }
            } else {
                a.q = appDeviceMac;
            }
        }
        return a.q;
    }

    public static String getOSVersion() {
        if (a.b == null || "".equals(a.b)) {
            a.b = Build.VERSION.SDK;
        }
        return a.b;
    }

    public static String getOperator(TelephonyManager telephonyManager) {
        if (a.k == null || "".equals(a.k)) {
            a.k = telephonyManager.getNetworkOperator();
        }
        return a.k;
    }

    public static String getPhoneModel() {
        if (a.l == null || "".equals(a.l)) {
            a.l = Build.MODEL;
        }
        return a.l;
    }

    public static String getSecretValue(String str) {
        String str2;
        String str3 = null;
        try {
            str3 = com.baidu.mobstat.a.d.a(com.baidu.mobstat.a.a.a("h9YLQoINGWyOBYYk", "h9YLQoINGWyOBYYk", str.getBytes()), "utf-8");
            com.baidu.mobstat.a.e.a("sdkstat", "加密=secretValue=" + str3);
            str2 = str3;
        } catch (Exception e) {
            e.printStackTrace();
            str2 = str3;
        }
        return str2 == null ? "" : str2;
    }

    public static int getTagValue() {
        return 1;
    }
}

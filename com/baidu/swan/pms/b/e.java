package com.baidu.swan.pms.b;

import android.text.TextUtils;
import java.util.Map;
/* loaded from: classes2.dex */
public class e {
    public static String Wr() {
        return String.format("%s/getpkg", Wu());
    }

    public static String Ws() {
        return String.format("%s/updatecore", Wu());
    }

    public static String Wt() {
        return String.format("%s/getplugin", Wu());
    }

    private static String Wu() {
        return com.baidu.swan.pms.e.VZ().ES();
    }

    public static String f(String str, Map<String, String> map) {
        return g(kt(str), map);
    }

    public static String g(String str, Map<String, String> map) {
        if (map != null) {
            for (String str2 : map.keySet()) {
                if (!TextUtils.isEmpty(map.get(str2))) {
                    str = B(str, str2, map.get(str2));
                }
            }
        }
        return str;
    }

    private static String kt(String str) {
        String B = B(B(B(B(B(B(B(B(B(str, "cuid", com.baidu.swan.pms.e.VZ().ET()), "ua", Wv()), "host_app", com.baidu.swan.pms.e.VZ().EU()), "host_app_ver", com.baidu.swan.pms.e.VZ().EV()), "host_os", com.baidu.swan.pms.e.a.WR()), "host_os_ver", com.baidu.swan.pms.e.a.getOsVersion()), "network", com.baidu.swan.pms.e.a.getNetworkInfo()), "sdk_ver", com.baidu.swan.pms.e.VZ().EW()), "cfrom", com.baidu.swan.c.c.YB());
        String VY = com.baidu.swan.pms.e.Wa().VY();
        if (!TextUtils.isEmpty(VY)) {
            return B(B, "extension_rule", VY);
        }
        return B;
    }

    private static String Wv() {
        int WS = com.baidu.swan.pms.e.a.WS();
        int WT = com.baidu.swan.pms.e.a.WT();
        int densityDpi = com.baidu.swan.pms.e.a.getDensityDpi();
        String WR = com.baidu.swan.pms.e.a.WR();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(WS);
        stringBuffer.append("_");
        stringBuffer.append(WT);
        stringBuffer.append("_");
        stringBuffer.append(WR);
        stringBuffer.append("_");
        stringBuffer.append(com.baidu.swan.pms.e.VZ().EV());
        stringBuffer.append("_");
        stringBuffer.append(densityDpi);
        return stringBuffer.toString();
    }

    private static String B(String str, String str2, String str3) {
        StringBuilder sb;
        StringBuilder sb2;
        String str4 = null;
        if (!TextUtils.isEmpty(str)) {
            String str5 = str2 + "=";
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
            } else if (str.indexOf("&" + str5, indexOf) < 0 && str.indexOf("?" + str5, indexOf) < 0) {
                int indexOf3 = str.indexOf("#");
                if (indexOf3 < 0) {
                    sb = new StringBuilder(str);
                } else {
                    str4 = str.substring(indexOf3);
                    str = str.substring(0, indexOf3);
                    sb = new StringBuilder(str);
                }
                if (!str.endsWith("&") && !str.endsWith("?")) {
                    sb.append("&");
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
}

package com.baidu.swan.pms.b;

import android.text.TextUtils;
import java.util.Map;
/* loaded from: classes2.dex */
public class e {
    public static String RN() {
        return String.format("%s/getpkg", RP());
    }

    public static String RO() {
        return String.format("%s/updatecore", RP());
    }

    private static String RP() {
        return com.baidu.swan.pms.e.Rw().Dg();
    }

    public static String g(String str, Map<String, String> map) {
        return h(jm(str), map);
    }

    public static String h(String str, Map<String, String> map) {
        if (map != null) {
            for (String str2 : map.keySet()) {
                if (!TextUtils.isEmpty(map.get(str2))) {
                    str = z(str, str2, map.get(str2));
                }
            }
        }
        return str;
    }

    private static String jm(String str) {
        String z = z(z(z(z(z(z(z(str, "cuid", com.baidu.swan.pms.e.Rw().Dh()), "ua", RQ()), "host_app", com.baidu.swan.pms.e.Rw().Di()), "host_app_ver", com.baidu.swan.pms.e.Rw().Dj()), "host_os", com.baidu.swan.pms.d.a.getOS()), "host_os_ver", com.baidu.swan.pms.d.a.getOsVersion()), "network", com.baidu.swan.pms.d.a.getNetworkInfo());
        String Rv = com.baidu.swan.pms.e.Rx().Rv();
        if (!TextUtils.isEmpty(Rv)) {
            return z(z, "extension_rule", Rv);
        }
        return z;
    }

    private static String RQ() {
        int So = com.baidu.swan.pms.d.a.So();
        int Sp = com.baidu.swan.pms.d.a.Sp();
        int densityDpi = com.baidu.swan.pms.d.a.getDensityDpi();
        String os = com.baidu.swan.pms.d.a.getOS();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(So);
        stringBuffer.append("_");
        stringBuffer.append(Sp);
        stringBuffer.append("_");
        stringBuffer.append(os);
        stringBuffer.append("_");
        stringBuffer.append(com.baidu.swan.pms.e.Rw().Dj());
        stringBuffer.append("_");
        stringBuffer.append(densityDpi);
        return stringBuffer.toString();
    }

    private static String z(String str, String str2, String str3) {
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

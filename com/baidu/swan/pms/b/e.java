package com.baidu.swan.pms.b;

import android.text.TextUtils;
import java.util.Map;
/* loaded from: classes2.dex */
public class e {
    public static String RL() {
        return String.format("%s/getpkg", RN());
    }

    public static String RM() {
        return String.format("%s/updatecore", RN());
    }

    private static String RN() {
        return com.baidu.swan.pms.e.Ru().De();
    }

    public static String g(String str, Map<String, String> map) {
        return h(jn(str), map);
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

    private static String jn(String str) {
        String z = z(z(z(z(z(z(z(str, "cuid", com.baidu.swan.pms.e.Ru().Df()), "ua", RO()), "host_app", com.baidu.swan.pms.e.Ru().Dg()), "host_app_ver", com.baidu.swan.pms.e.Ru().Dh()), "host_os", com.baidu.swan.pms.d.a.getOS()), "host_os_ver", com.baidu.swan.pms.d.a.getOsVersion()), "network", com.baidu.swan.pms.d.a.getNetworkInfo());
        String Rt = com.baidu.swan.pms.e.Rv().Rt();
        if (!TextUtils.isEmpty(Rt)) {
            return z(z, "extension_rule", Rt);
        }
        return z;
    }

    private static String RO() {
        int Sm = com.baidu.swan.pms.d.a.Sm();
        int Sn = com.baidu.swan.pms.d.a.Sn();
        int densityDpi = com.baidu.swan.pms.d.a.getDensityDpi();
        String os = com.baidu.swan.pms.d.a.getOS();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(Sm);
        stringBuffer.append("_");
        stringBuffer.append(Sn);
        stringBuffer.append("_");
        stringBuffer.append(os);
        stringBuffer.append("_");
        stringBuffer.append(com.baidu.swan.pms.e.Ru().Dh());
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

package com.baidu.swan.pms.b;

import android.text.TextUtils;
import java.util.Map;
/* loaded from: classes2.dex */
public class e {
    public static String Vy() {
        return String.format("%s/getpkg", VB());
    }

    public static String Vz() {
        return String.format("%s/updatecore", VB());
    }

    public static String VA() {
        return String.format("%s/getplugin", VB());
    }

    private static String VB() {
        return com.baidu.swan.pms.e.Vg().Ej();
    }

    public static String f(String str, Map<String, String> map) {
        return g(kl(str), map);
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

    private static String kl(String str) {
        String B = B(B(B(B(B(B(B(B(B(str, "cuid", com.baidu.swan.pms.e.Vg().Ek()), "ua", VC()), "host_app", com.baidu.swan.pms.e.Vg().El()), "host_app_ver", com.baidu.swan.pms.e.Vg().Em()), "host_os", com.baidu.swan.pms.e.a.getOS()), "host_os_ver", com.baidu.swan.pms.e.a.getOsVersion()), "network", com.baidu.swan.pms.e.a.getNetworkInfo()), "sdk_ver", com.baidu.swan.pms.e.Vg().En()), "cfrom", com.baidu.swan.c.c.XF());
        String Vf = com.baidu.swan.pms.e.Vh().Vf();
        if (!TextUtils.isEmpty(Vf)) {
            return B(B, "extension_rule", Vf);
        }
        return B;
    }

    private static String VC() {
        int VY = com.baidu.swan.pms.e.a.VY();
        int VZ = com.baidu.swan.pms.e.a.VZ();
        int densityDpi = com.baidu.swan.pms.e.a.getDensityDpi();
        String os = com.baidu.swan.pms.e.a.getOS();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(VY);
        stringBuffer.append("_");
        stringBuffer.append(VZ);
        stringBuffer.append("_");
        stringBuffer.append(os);
        stringBuffer.append("_");
        stringBuffer.append(com.baidu.swan.pms.e.Vg().Em());
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

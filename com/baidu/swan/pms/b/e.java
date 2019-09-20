package com.baidu.swan.pms.b;

import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import java.util.Map;
/* loaded from: classes2.dex */
public class e {
    public static String Wv() {
        return String.format("%s/getpkg", Wy());
    }

    public static String Ww() {
        return String.format("%s/updatecore", Wy());
    }

    public static String Wx() {
        return String.format("%s/getplugin", Wy());
    }

    private static String Wy() {
        return com.baidu.swan.pms.e.Wd().EW();
    }

    public static String f(String str, Map<String, String> map) {
        return g(kv(str), map);
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

    private static String kv(String str) {
        String B = B(B(B(B(B(B(B(B(B(str, DpStatConstants.KEY_CUID, com.baidu.swan.pms.e.Wd().EX()), "ua", Wz()), "host_app", com.baidu.swan.pms.e.Wd().EY()), "host_app_ver", com.baidu.swan.pms.e.Wd().EZ()), "host_os", com.baidu.swan.pms.e.a.WV()), "host_os_ver", com.baidu.swan.pms.e.a.getOsVersion()), DpStatConstants.KEY_NETWORK, com.baidu.swan.pms.e.a.getNetworkInfo()), "sdk_ver", com.baidu.swan.pms.e.Wd().Fa()), "cfrom", com.baidu.swan.c.c.YF());
        String Wc = com.baidu.swan.pms.e.We().Wc();
        if (!TextUtils.isEmpty(Wc)) {
            return B(B, "extension_rule", Wc);
        }
        return B;
    }

    private static String Wz() {
        int WW = com.baidu.swan.pms.e.a.WW();
        int WX = com.baidu.swan.pms.e.a.WX();
        int densityDpi = com.baidu.swan.pms.e.a.getDensityDpi();
        String WV = com.baidu.swan.pms.e.a.WV();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(WW);
        stringBuffer.append("_");
        stringBuffer.append(WX);
        stringBuffer.append("_");
        stringBuffer.append(WV);
        stringBuffer.append("_");
        stringBuffer.append(com.baidu.swan.pms.e.Wd().EZ());
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

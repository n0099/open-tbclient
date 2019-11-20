package com.baidu.swan.pms.b;

import android.text.TextUtils;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import java.util.Map;
/* loaded from: classes2.dex */
public class e {
    public static String abi() {
        return String.format("%s/getpkg", abl());
    }

    public static String abj() {
        return String.format("%s/updatecore", abl());
    }

    public static String abk() {
        return String.format("%s/getplugin", abl());
    }

    private static String abl() {
        return com.baidu.swan.pms.e.aaQ().JR();
    }

    public static String f(String str, Map<String, String> map) {
        return g(kX(str), map);
    }

    public static String g(String str, Map<String, String> map) {
        if (map != null) {
            for (String str2 : map.keySet()) {
                if (!TextUtils.isEmpty(map.get(str2))) {
                    str = F(str, str2, map.get(str2));
                }
            }
        }
        return str;
    }

    private static String kX(String str) {
        String F = F(F(F(F(F(F(F(F(F(str, "cuid", com.baidu.swan.pms.e.aaQ().JS()), "ua", abm()), "host_app", com.baidu.swan.pms.e.aaQ().JT()), "host_app_ver", com.baidu.swan.pms.e.aaQ().JU()), "host_os", com.baidu.swan.pms.e.a.abI()), "host_os_ver", com.baidu.swan.pms.e.a.getOsVersion()), "network", com.baidu.swan.pms.e.a.getNetworkInfo()), "sdk_ver", com.baidu.swan.pms.e.aaQ().JV()), BdStatsConstant.StatsKey.CURRENT_CHANNEL, com.baidu.swan.c.c.ads());
        String aaP = com.baidu.swan.pms.e.aaR().aaP();
        if (!TextUtils.isEmpty(aaP)) {
            return F(F, "extension_rule", aaP);
        }
        return F;
    }

    private static String abm() {
        int abJ = com.baidu.swan.pms.e.a.abJ();
        int abK = com.baidu.swan.pms.e.a.abK();
        int densityDpi = com.baidu.swan.pms.e.a.getDensityDpi();
        String abI = com.baidu.swan.pms.e.a.abI();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(abJ);
        stringBuffer.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
        stringBuffer.append(abK);
        stringBuffer.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
        stringBuffer.append(abI);
        stringBuffer.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
        stringBuffer.append(com.baidu.swan.pms.e.aaQ().JU());
        stringBuffer.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
        stringBuffer.append(densityDpi);
        return stringBuffer.toString();
    }

    private static String F(String str, String str2, String str3) {
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

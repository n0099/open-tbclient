package com.baidu.swan.pms.b;

import android.text.TextUtils;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import java.util.Map;
/* loaded from: classes2.dex */
public class e {
    public static String abk() {
        return String.format("%s/getpkg", abn());
    }

    public static String abl() {
        return String.format("%s/updatecore", abn());
    }

    public static String abm() {
        return String.format("%s/getplugin", abn());
    }

    private static String abn() {
        return com.baidu.swan.pms.e.aaS().JQ();
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
        String F = F(F(F(F(F(F(F(F(F(str, "cuid", com.baidu.swan.pms.e.aaS().JR()), "ua", abo()), "host_app", com.baidu.swan.pms.e.aaS().JS()), "host_app_ver", com.baidu.swan.pms.e.aaS().JT()), "host_os", com.baidu.swan.pms.e.a.abK()), "host_os_ver", com.baidu.swan.pms.e.a.getOsVersion()), "network", com.baidu.swan.pms.e.a.getNetworkInfo()), "sdk_ver", com.baidu.swan.pms.e.aaS().JU()), BdStatsConstant.StatsKey.CURRENT_CHANNEL, com.baidu.swan.c.c.adu());
        String aaR = com.baidu.swan.pms.e.aaT().aaR();
        if (!TextUtils.isEmpty(aaR)) {
            return F(F, "extension_rule", aaR);
        }
        return F;
    }

    private static String abo() {
        int abL = com.baidu.swan.pms.e.a.abL();
        int abM = com.baidu.swan.pms.e.a.abM();
        int densityDpi = com.baidu.swan.pms.e.a.getDensityDpi();
        String abK = com.baidu.swan.pms.e.a.abK();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(abL);
        stringBuffer.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
        stringBuffer.append(abM);
        stringBuffer.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
        stringBuffer.append(abK);
        stringBuffer.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
        stringBuffer.append(com.baidu.swan.pms.e.aaS().JT());
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

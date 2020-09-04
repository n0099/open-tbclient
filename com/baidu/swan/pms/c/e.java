package com.baidu.swan.pms.c;

import android.text.TextUtils;
import com.baidu.fsg.base.statistics.j;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.swan.c.h;
import java.util.Map;
/* loaded from: classes14.dex */
public class e {
    public static String aTJ() {
        return String.format("%s/getpkg", aTN());
    }

    public static String aTK() {
        return String.format("%s/updatecore", aTN());
    }

    public static String aTL() {
        return String.format("%s/fetchpkglist", aTN());
    }

    public static String aTM() {
        return String.format("%s/getplugin", aTN());
    }

    public static String aTN() {
        return com.baidu.swan.pms.d.aTn().apR();
    }

    public static String processUrl(String str) {
        return wG(str);
    }

    public static String k(String str, Map<String, String> map) {
        return l(wG(str), map);
    }

    public static String l(String str, Map<String, String> map) {
        if (map != null) {
            for (String str2 : map.keySet()) {
                if (!TextUtils.isEmpty(map.get(str2))) {
                    str = h.addParam(str, str2, map.get(str2));
                }
            }
        }
        return str;
    }

    private static String wG(String str) {
        String addParam = h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(str, "cuid", com.baidu.swan.pms.d.aTn().apS()), "uuid", com.baidu.swan.pms.d.aTn().getUUID()), "ut", com.baidu.swan.pms.d.aTn().apT()), j.c, h.xy(com.baidu.swan.pms.d.aTn().apV())), "host_app", com.baidu.swan.pms.d.aTn().apU()), "host_app_ver", com.baidu.swan.pms.d.aTn().apV()), "host_os", com.baidu.swan.c.a.getOS()), "host_os_ver", com.baidu.swan.c.a.getOsVersion()), "network", com.baidu.swan.c.a.getNetworkInfo()), "sdk_ver", com.baidu.swan.pms.d.aTn().apW());
        String aTm = com.baidu.swan.pms.d.aTo().aTm();
        if (!TextUtils.isEmpty(aTm)) {
            addParam = h.addParam(addParam, "extension_rule", aTm);
        }
        String aqc = com.baidu.swan.pms.d.aTn().aqc();
        if (!TextUtils.isEmpty(aqc)) {
            return h.addParam(addParam, UbcStatConstant.KEY_CONTENT_EXT_SID, aqc);
        }
        return addParam;
    }
}

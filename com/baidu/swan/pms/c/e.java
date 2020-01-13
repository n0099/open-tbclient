package com.baidu.swan.pms.c;

import android.text.TextUtils;
import com.baidu.fsg.base.statistics.j;
import com.baidu.swan.d.h;
import java.util.Map;
/* loaded from: classes10.dex */
public class e {
    public static String arv() {
        return String.format("%s/getpkg", arz());
    }

    public static String arw() {
        return String.format("%s/updatecore", arz());
    }

    public static String arx() {
        return String.format("%s/fetchpkglist", arz());
    }

    public static String ary() {
        return String.format("%s/getplugin", arz());
    }

    public static String arz() {
        return com.baidu.swan.pms.d.aqZ().SB();
    }

    public static String g(String str, Map<String, String> map) {
        return h(qe(str), map);
    }

    public static String h(String str, Map<String, String> map) {
        if (map != null) {
            for (String str2 : map.keySet()) {
                if (!TextUtils.isEmpty(map.get(str2))) {
                    str = h.addParam(str, str2, map.get(str2));
                }
            }
        }
        return str;
    }

    private static String qe(String str) {
        String addParam = h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(str, "cuid", com.baidu.swan.pms.d.aqZ().SC()), "uuid", com.baidu.swan.pms.d.aqZ().getUUID()), j.c, h.qV(com.baidu.swan.pms.d.aqZ().SE())), "host_app", com.baidu.swan.pms.d.aqZ().SD()), "host_app_ver", com.baidu.swan.pms.d.aqZ().SE()), "host_os", com.baidu.swan.d.a.getOS()), "host_os_ver", com.baidu.swan.d.a.getOsVersion()), "network", com.baidu.swan.d.a.getNetworkInfo()), "sdk_ver", com.baidu.swan.pms.d.aqZ().SF());
        String aqY = com.baidu.swan.pms.d.ara().aqY();
        if (!TextUtils.isEmpty(aqY)) {
            addParam = h.addParam(addParam, "extension_rule", aqY);
        }
        String SL = com.baidu.swan.pms.d.aqZ().SL();
        if (!TextUtils.isEmpty(SL)) {
            return h.addParam(addParam, "sid", SL);
        }
        return addParam;
    }
}

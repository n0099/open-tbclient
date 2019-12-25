package com.baidu.swan.pms.c;

import android.text.TextUtils;
import com.baidu.fsg.base.statistics.j;
import com.baidu.swan.d.h;
import java.util.Map;
/* loaded from: classes9.dex */
public class e {
    public static String arc() {
        return String.format("%s/getpkg", arg());
    }

    public static String ard() {
        return String.format("%s/updatecore", arg());
    }

    public static String are() {
        return String.format("%s/fetchpkglist", arg());
    }

    public static String arf() {
        return String.format("%s/getplugin", arg());
    }

    public static String arg() {
        return com.baidu.swan.pms.d.aqG().Sf();
    }

    public static String g(String str, Map<String, String> map) {
        return h(qb(str), map);
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

    private static String qb(String str) {
        String addParam = h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(str, "cuid", com.baidu.swan.pms.d.aqG().Sg()), "uuid", com.baidu.swan.pms.d.aqG().getUUID()), j.c, h.qS(com.baidu.swan.pms.d.aqG().Si())), "host_app", com.baidu.swan.pms.d.aqG().Sh()), "host_app_ver", com.baidu.swan.pms.d.aqG().Si()), "host_os", com.baidu.swan.d.a.getOS()), "host_os_ver", com.baidu.swan.d.a.getOsVersion()), "network", com.baidu.swan.d.a.getNetworkInfo()), "sdk_ver", com.baidu.swan.pms.d.aqG().Sj());
        String aqF = com.baidu.swan.pms.d.aqH().aqF();
        if (!TextUtils.isEmpty(aqF)) {
            addParam = h.addParam(addParam, "extension_rule", aqF);
        }
        String Sp = com.baidu.swan.pms.d.aqG().Sp();
        if (!TextUtils.isEmpty(Sp)) {
            return h.addParam(addParam, "sid", Sp);
        }
        return addParam;
    }
}

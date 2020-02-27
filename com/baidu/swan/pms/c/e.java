package com.baidu.swan.pms.c;

import android.text.TextUtils;
import com.baidu.fsg.base.statistics.j;
import com.baidu.swan.d.h;
import java.util.Map;
/* loaded from: classes11.dex */
public class e {
    public static String atJ() {
        return String.format("%s/getpkg", atN());
    }

    public static String atK() {
        return String.format("%s/updatecore", atN());
    }

    public static String atL() {
        return String.format("%s/fetchpkglist", atN());
    }

    public static String atM() {
        return String.format("%s/getplugin", atN());
    }

    public static String atN() {
        return com.baidu.swan.pms.d.atn().UP();
    }

    public static String g(String str, Map<String, String> map) {
        return h(qt(str), map);
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

    private static String qt(String str) {
        String addParam = h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(str, "cuid", com.baidu.swan.pms.d.atn().UQ()), "uuid", com.baidu.swan.pms.d.atn().getUUID()), j.c, h.rk(com.baidu.swan.pms.d.atn().US())), "host_app", com.baidu.swan.pms.d.atn().UR()), "host_app_ver", com.baidu.swan.pms.d.atn().US()), "host_os", com.baidu.swan.d.a.getOS()), "host_os_ver", com.baidu.swan.d.a.getOsVersion()), "network", com.baidu.swan.d.a.getNetworkInfo()), "sdk_ver", com.baidu.swan.pms.d.atn().UT());
        String atm = com.baidu.swan.pms.d.ato().atm();
        if (!TextUtils.isEmpty(atm)) {
            addParam = h.addParam(addParam, "extension_rule", atm);
        }
        String UZ = com.baidu.swan.pms.d.atn().UZ();
        if (!TextUtils.isEmpty(UZ)) {
            return h.addParam(addParam, "sid", UZ);
        }
        return addParam;
    }
}

package com.baidu.swan.pms.c;

import android.text.TextUtils;
import com.baidu.fsg.base.statistics.j;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.swan.d.h;
import java.util.Map;
/* loaded from: classes11.dex */
public class e {
    public static String aBY() {
        return String.format("%s/getpkg", aCc());
    }

    public static String aBZ() {
        return String.format("%s/updatecore", aCc());
    }

    public static String aCa() {
        return String.format("%s/fetchpkglist", aCc());
    }

    public static String aCb() {
        return String.format("%s/getplugin", aCc());
    }

    public static String aCc() {
        return com.baidu.swan.pms.d.aBC().acJ();
    }

    public static String h(String str, Map<String, String> map) {
        return i(rF(str), map);
    }

    public static String i(String str, Map<String, String> map) {
        if (map != null) {
            for (String str2 : map.keySet()) {
                if (!TextUtils.isEmpty(map.get(str2))) {
                    str = h.addParam(str, str2, map.get(str2));
                }
            }
        }
        return str;
    }

    private static String rF(String str) {
        String addParam = h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(str, "cuid", com.baidu.swan.pms.d.aBC().acK()), "uuid", com.baidu.swan.pms.d.aBC().getUUID()), j.c, h.sx(com.baidu.swan.pms.d.aBC().acM())), "host_app", com.baidu.swan.pms.d.aBC().acL()), "host_app_ver", com.baidu.swan.pms.d.aBC().acM()), "host_os", com.baidu.swan.d.a.getOS()), "host_os_ver", com.baidu.swan.d.a.getOsVersion()), "network", com.baidu.swan.d.a.getNetworkInfo()), "sdk_ver", com.baidu.swan.pms.d.aBC().acN());
        String aBB = com.baidu.swan.pms.d.aBD().aBB();
        if (!TextUtils.isEmpty(aBB)) {
            addParam = h.addParam(addParam, "extension_rule", aBB);
        }
        String acT = com.baidu.swan.pms.d.aBC().acT();
        if (!TextUtils.isEmpty(acT)) {
            return h.addParam(addParam, UbcStatConstant.KEY_CONTENT_EXT_SID, acT);
        }
        return addParam;
    }
}

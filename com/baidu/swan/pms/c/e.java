package com.baidu.swan.pms.c;

import android.text.TextUtils;
import com.baidu.fsg.base.statistics.j;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.swan.c.h;
import java.util.Map;
/* loaded from: classes24.dex */
public class e {
    public static String aUv() {
        return String.format("%s/getpkg", aUz());
    }

    public static String aUw() {
        return String.format("%s/updatecore", aUz());
    }

    public static String aUx() {
        return String.format("%s/fetchpkglist", aUz());
    }

    public static String aUy() {
        return String.format("%s/getplugin", aUz());
    }

    public static String aUz() {
        return com.baidu.swan.pms.d.aTZ().aqB();
    }

    public static String processUrl(String str) {
        return wZ(str);
    }

    public static String k(String str, Map<String, String> map) {
        return l(wZ(str), map);
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

    private static String wZ(String str) {
        String addParam = h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(str, "cuid", com.baidu.swan.pms.d.aTZ().aqC()), "uuid", com.baidu.swan.pms.d.aTZ().getUUID()), "ut", com.baidu.swan.pms.d.aTZ().aqD()), j.c, h.xR(com.baidu.swan.pms.d.aTZ().aqF())), "host_app", com.baidu.swan.pms.d.aTZ().aqE()), "host_app_ver", com.baidu.swan.pms.d.aTZ().aqF()), "host_os", com.baidu.swan.c.a.getOS()), "host_os_ver", com.baidu.swan.c.a.getOsVersion()), "network", com.baidu.swan.c.a.getNetworkInfo()), "sdk_ver", com.baidu.swan.pms.d.aTZ().aqG());
        String aTY = com.baidu.swan.pms.d.aUa().aTY();
        if (!TextUtils.isEmpty(aTY)) {
            addParam = h.addParam(addParam, "extension_rule", aTY);
        }
        String aqM = com.baidu.swan.pms.d.aTZ().aqM();
        if (!TextUtils.isEmpty(aqM)) {
            return h.addParam(addParam, UbcStatConstant.KEY_CONTENT_EXT_SID, aqM);
        }
        return addParam;
    }
}

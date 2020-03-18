package com.baidu.swan.pms.c;

import android.text.TextUtils;
import com.baidu.fsg.base.statistics.j;
import com.baidu.swan.d.h;
import java.util.Map;
/* loaded from: classes11.dex */
public class e {
    public static String atO() {
        return String.format("%s/getpkg", atS());
    }

    public static String atP() {
        return String.format("%s/updatecore", atS());
    }

    public static String atQ() {
        return String.format("%s/fetchpkglist", atS());
    }

    public static String atR() {
        return String.format("%s/getplugin", atS());
    }

    public static String atS() {
        return com.baidu.swan.pms.d.ats().UU();
    }

    public static String g(String str, Map<String, String> map) {
        return h(qs(str), map);
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

    private static String qs(String str) {
        String addParam = h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(str, "cuid", com.baidu.swan.pms.d.ats().UV()), "uuid", com.baidu.swan.pms.d.ats().getUUID()), j.c, h.rj(com.baidu.swan.pms.d.ats().UX())), "host_app", com.baidu.swan.pms.d.ats().UW()), "host_app_ver", com.baidu.swan.pms.d.ats().UX()), "host_os", com.baidu.swan.d.a.getOS()), "host_os_ver", com.baidu.swan.d.a.getOsVersion()), "network", com.baidu.swan.d.a.getNetworkInfo()), "sdk_ver", com.baidu.swan.pms.d.ats().UY());
        String atr = com.baidu.swan.pms.d.att().atr();
        if (!TextUtils.isEmpty(atr)) {
            addParam = h.addParam(addParam, "extension_rule", atr);
        }
        String Ve = com.baidu.swan.pms.d.ats().Ve();
        if (!TextUtils.isEmpty(Ve)) {
            return h.addParam(addParam, "sid", Ve);
        }
        return addParam;
    }
}

package com.baidu.swan.pms.c;

import android.text.TextUtils;
import com.baidu.fsg.base.statistics.j;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.swan.c.h;
import java.util.Map;
/* loaded from: classes3.dex */
public class e {
    public static String bcL() {
        return String.format("%s/getpkg", bcP());
    }

    public static String bcM() {
        return String.format("%s/updatecore", bcP());
    }

    public static String bcN() {
        return String.format("%s/fetchpkglist", bcP());
    }

    public static String bcO() {
        return String.format("%s/getplugin", bcP());
    }

    public static String bcP() {
        return com.baidu.swan.pms.d.bcp().ayd();
    }

    public static String processUrl(String str) {
        return yb(str);
    }

    public static String i(String str, Map<String, String> map) {
        return j(yb(str), map);
    }

    public static String j(String str, Map<String, String> map) {
        if (map != null) {
            for (String str2 : map.keySet()) {
                if (!TextUtils.isEmpty(map.get(str2))) {
                    str = h.addParam(str, str2, map.get(str2));
                }
            }
        }
        return str;
    }

    private static String yb(String str) {
        String addParam = h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(str, "cuid", com.baidu.swan.pms.d.bcp().aye()), "uuid", com.baidu.swan.pms.d.bcp().getUUID()), "ut", com.baidu.swan.pms.d.bcp().ayf()), j.c, h.yS(com.baidu.swan.pms.d.bcp().ayh())), "host_app", com.baidu.swan.pms.d.bcp().ayg()), "host_app_ver", com.baidu.swan.pms.d.bcp().ayh()), "host_os", com.baidu.swan.c.a.getOS()), "host_os_ver", com.baidu.swan.c.a.getOsVersion()), "network", com.baidu.swan.c.a.getNetworkInfo()), "sdk_ver", com.baidu.swan.pms.d.bcp().ayi());
        String bco = com.baidu.swan.pms.d.bcq().bco();
        if (!TextUtils.isEmpty(bco)) {
            addParam = h.addParam(addParam, "extension_rule", bco);
        }
        String ayo = com.baidu.swan.pms.d.bcp().ayo();
        if (!TextUtils.isEmpty(ayo)) {
            return h.addParam(addParam, UbcStatConstant.KEY_CONTENT_EXT_SID, ayo);
        }
        return addParam;
    }
}

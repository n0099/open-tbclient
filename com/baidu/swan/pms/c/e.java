package com.baidu.swan.pms.c;

import android.text.TextUtils;
import com.baidu.fsg.base.statistics.j;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.swan.c.h;
import java.util.Map;
/* loaded from: classes6.dex */
public class e {
    public static String baQ() {
        return String.format("%s/getpkg", baU());
    }

    public static String baR() {
        return String.format("%s/updatecore", baU());
    }

    public static String baS() {
        return String.format("%s/fetchpkglist", baU());
    }

    public static String baT() {
        return String.format("%s/getplugin", baU());
    }

    public static String baU() {
        return com.baidu.swan.pms.d.bau().awZ();
    }

    public static String processUrl(String str) {
        return yn(str);
    }

    public static String j(String str, Map<String, String> map) {
        return k(yn(str), map);
    }

    public static String k(String str, Map<String, String> map) {
        if (map != null) {
            for (String str2 : map.keySet()) {
                if (!TextUtils.isEmpty(map.get(str2))) {
                    str = h.addParam(str, str2, map.get(str2));
                }
            }
        }
        return str;
    }

    private static String yn(String str) {
        String addParam = h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(str, "cuid", com.baidu.swan.pms.d.bau().axa()), "uuid", com.baidu.swan.pms.d.bau().getUUID()), "ut", com.baidu.swan.pms.d.bau().axb()), j.c, h.zf(com.baidu.swan.pms.d.bau().axd())), "host_app", com.baidu.swan.pms.d.bau().axc()), "host_app_ver", com.baidu.swan.pms.d.bau().axd()), "host_os", com.baidu.swan.c.a.getOS()), "host_os_ver", com.baidu.swan.c.a.getOsVersion()), "network", com.baidu.swan.c.a.getNetworkInfo()), "sdk_ver", com.baidu.swan.pms.d.bau().axe());
        String bat = com.baidu.swan.pms.d.bav().bat();
        if (!TextUtils.isEmpty(bat)) {
            addParam = h.addParam(addParam, "extension_rule", bat);
        }
        String axk = com.baidu.swan.pms.d.bau().axk();
        if (!TextUtils.isEmpty(axk)) {
            return h.addParam(addParam, UbcStatConstant.KEY_CONTENT_EXT_SID, axk);
        }
        return addParam;
    }
}

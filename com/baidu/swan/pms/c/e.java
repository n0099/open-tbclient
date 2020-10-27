package com.baidu.swan.pms.c;

import android.text.TextUtils;
import com.baidu.fsg.base.statistics.j;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.swan.c.h;
import java.util.Map;
/* loaded from: classes15.dex */
public class e {
    public static String aYX() {
        return String.format("%s/getpkg", aZb());
    }

    public static String aYY() {
        return String.format("%s/updatecore", aZb());
    }

    public static String aYZ() {
        return String.format("%s/fetchpkglist", aZb());
    }

    public static String aZa() {
        return String.format("%s/getplugin", aZb());
    }

    public static String aZb() {
        return com.baidu.swan.pms.d.aYB().avh();
    }

    public static String processUrl(String str) {
        return ye(str);
    }

    public static String k(String str, Map<String, String> map) {
        return l(ye(str), map);
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

    private static String ye(String str) {
        String addParam = h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(str, "cuid", com.baidu.swan.pms.d.aYB().avi()), "uuid", com.baidu.swan.pms.d.aYB().getUUID()), "ut", com.baidu.swan.pms.d.aYB().avj()), j.c, h.yW(com.baidu.swan.pms.d.aYB().avl())), "host_app", com.baidu.swan.pms.d.aYB().avk()), "host_app_ver", com.baidu.swan.pms.d.aYB().avl()), "host_os", com.baidu.swan.c.a.getOS()), "host_os_ver", com.baidu.swan.c.a.getOsVersion()), "network", com.baidu.swan.c.a.getNetworkInfo()), "sdk_ver", com.baidu.swan.pms.d.aYB().avm());
        String aYA = com.baidu.swan.pms.d.aYC().aYA();
        if (!TextUtils.isEmpty(aYA)) {
            addParam = h.addParam(addParam, "extension_rule", aYA);
        }
        String avs = com.baidu.swan.pms.d.aYB().avs();
        if (!TextUtils.isEmpty(avs)) {
            return h.addParam(addParam, UbcStatConstant.KEY_CONTENT_EXT_SID, avs);
        }
        return addParam;
    }
}

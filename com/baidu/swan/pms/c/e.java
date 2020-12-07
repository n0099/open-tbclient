package com.baidu.swan.pms.c;

import android.text.TextUtils;
import com.baidu.fsg.base.statistics.j;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.swan.c.h;
import java.util.Map;
/* loaded from: classes6.dex */
public class e {
    public static String bdV() {
        return String.format("%s/getpkg", bdZ());
    }

    public static String bdW() {
        return String.format("%s/updatecore", bdZ());
    }

    public static String bdX() {
        return String.format("%s/fetchpkglist", bdZ());
    }

    public static String bdY() {
        return String.format("%s/getplugin", bdZ());
    }

    public static String bdZ() {
        return com.baidu.swan.pms.d.bdz().aAh();
    }

    public static String processUrl(String str) {
        return yU(str);
    }

    public static String j(String str, Map<String, String> map) {
        return k(yU(str), map);
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

    private static String yU(String str) {
        String addParam = h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(str, "cuid", com.baidu.swan.pms.d.bdz().aAi()), "uuid", com.baidu.swan.pms.d.bdz().getUUID()), "ut", com.baidu.swan.pms.d.bdz().aAj()), j.c, h.zM(com.baidu.swan.pms.d.bdz().aAl())), "host_app", com.baidu.swan.pms.d.bdz().aAk()), "host_app_ver", com.baidu.swan.pms.d.bdz().aAl()), "host_os", com.baidu.swan.c.a.getOS()), "host_os_ver", com.baidu.swan.c.a.getOsVersion()), "network", com.baidu.swan.c.a.getNetworkInfo()), "sdk_ver", com.baidu.swan.pms.d.bdz().aAm());
        String bdy = com.baidu.swan.pms.d.bdA().bdy();
        if (!TextUtils.isEmpty(bdy)) {
            addParam = h.addParam(addParam, "extension_rule", bdy);
        }
        String aAs = com.baidu.swan.pms.d.bdz().aAs();
        if (!TextUtils.isEmpty(aAs)) {
            return h.addParam(addParam, UbcStatConstant.KEY_CONTENT_EXT_SID, aAs);
        }
        return addParam;
    }
}

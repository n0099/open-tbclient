package com.baidu.swan.pms.c;

import android.text.TextUtils;
import com.baidu.fsg.base.statistics.j;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.swan.c.h;
import java.util.Map;
/* loaded from: classes15.dex */
public class e {
    public static String aXe() {
        return String.format("%s/getpkg", aXi());
    }

    public static String aXf() {
        return String.format("%s/updatecore", aXi());
    }

    public static String aXg() {
        return String.format("%s/fetchpkglist", aXi());
    }

    public static String aXh() {
        return String.format("%s/getplugin", aXi());
    }

    public static String aXi() {
        return com.baidu.swan.pms.d.aWI().atn();
    }

    public static String processUrl(String str) {
        return xL(str);
    }

    public static String k(String str, Map<String, String> map) {
        return l(xL(str), map);
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

    private static String xL(String str) {
        String addParam = h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(str, "cuid", com.baidu.swan.pms.d.aWI().ato()), "uuid", com.baidu.swan.pms.d.aWI().getUUID()), "ut", com.baidu.swan.pms.d.aWI().atp()), j.c, h.yD(com.baidu.swan.pms.d.aWI().atr())), "host_app", com.baidu.swan.pms.d.aWI().atq()), "host_app_ver", com.baidu.swan.pms.d.aWI().atr()), "host_os", com.baidu.swan.c.a.getOS()), "host_os_ver", com.baidu.swan.c.a.getOsVersion()), "network", com.baidu.swan.c.a.getNetworkInfo()), "sdk_ver", com.baidu.swan.pms.d.aWI().ats());
        String aWH = com.baidu.swan.pms.d.aWJ().aWH();
        if (!TextUtils.isEmpty(aWH)) {
            addParam = h.addParam(addParam, "extension_rule", aWH);
        }
        String aty = com.baidu.swan.pms.d.aWI().aty();
        if (!TextUtils.isEmpty(aty)) {
            return h.addParam(addParam, UbcStatConstant.KEY_CONTENT_EXT_SID, aty);
        }
        return addParam;
    }
}

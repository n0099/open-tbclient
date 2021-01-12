package com.baidu.swan.pms.c;

import android.text.TextUtils;
import com.baidu.fsg.base.statistics.j;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.swan.c.h;
import java.util.Map;
/* loaded from: classes6.dex */
public class e {
    public static String bcy() {
        return String.format("%s/getpkg", bcC());
    }

    public static String bcz() {
        return String.format("%s/updatecore", bcC());
    }

    public static String bcA() {
        return String.format("%s/fetchpkglist", bcC());
    }

    public static String bcB() {
        return String.format("%s/getplugin", bcC());
    }

    public static String bcC() {
        return com.baidu.swan.pms.d.bcc().axF();
    }

    public static String processUrl(String str) {
        return xI(str);
    }

    public static String j(String str, Map<String, String> map) {
        return k(xI(str), map);
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

    private static String xI(String str) {
        String addParam = h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(str, "cuid", com.baidu.swan.pms.d.bcc().axG()), "uuid", com.baidu.swan.pms.d.bcc().getUUID()), "ut", com.baidu.swan.pms.d.bcc().axH()), j.c, h.yA(com.baidu.swan.pms.d.bcc().axJ())), "host_app", com.baidu.swan.pms.d.bcc().axI()), "host_app_ver", com.baidu.swan.pms.d.bcc().axJ()), "host_os", com.baidu.swan.c.a.getOS()), "host_os_ver", com.baidu.swan.c.a.getOsVersion()), "network", com.baidu.swan.c.a.getNetworkInfo()), "sdk_ver", com.baidu.swan.pms.d.bcc().axK());
        String bcb = com.baidu.swan.pms.d.bcd().bcb();
        if (!TextUtils.isEmpty(bcb)) {
            addParam = h.addParam(addParam, "extension_rule", bcb);
        }
        String axQ = com.baidu.swan.pms.d.bcc().axQ();
        if (!TextUtils.isEmpty(axQ)) {
            return h.addParam(addParam, UbcStatConstant.KEY_CONTENT_EXT_SID, axQ);
        }
        return addParam;
    }
}

package com.baidu.swan.pms.c;

import android.text.TextUtils;
import com.baidu.fsg.base.statistics.j;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.swan.c.h;
import java.util.Map;
/* loaded from: classes6.dex */
public class e {
    public static String bgs() {
        return String.format("%s/getpkg", bgw());
    }

    public static String bgt() {
        return String.format("%s/updatecore", bgw());
    }

    public static String bgu() {
        return String.format("%s/fetchpkglist", bgw());
    }

    public static String bgv() {
        return String.format("%s/getplugin", bgw());
    }

    public static String bgw() {
        return com.baidu.swan.pms.d.bfW().aBz();
    }

    public static String processUrl(String str) {
        return yT(str);
    }

    public static String j(String str, Map<String, String> map) {
        return k(yT(str), map);
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

    private static String yT(String str) {
        String addParam = h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(str, "cuid", com.baidu.swan.pms.d.bfW().aBA()), "uuid", com.baidu.swan.pms.d.bfW().getUUID()), "ut", com.baidu.swan.pms.d.bfW().aBB()), j.c, h.zL(com.baidu.swan.pms.d.bfW().aBD())), "host_app", com.baidu.swan.pms.d.bfW().aBC()), "host_app_ver", com.baidu.swan.pms.d.bfW().aBD()), "host_os", com.baidu.swan.c.a.getOS()), "host_os_ver", com.baidu.swan.c.a.getOsVersion()), "network", com.baidu.swan.c.a.getNetworkInfo()), "sdk_ver", com.baidu.swan.pms.d.bfW().aBE());
        String bfV = com.baidu.swan.pms.d.bfX().bfV();
        if (!TextUtils.isEmpty(bfV)) {
            addParam = h.addParam(addParam, "extension_rule", bfV);
        }
        String aBK = com.baidu.swan.pms.d.bfW().aBK();
        if (!TextUtils.isEmpty(aBK)) {
            return h.addParam(addParam, UbcStatConstant.KEY_CONTENT_EXT_SID, aBK);
        }
        return addParam;
    }
}

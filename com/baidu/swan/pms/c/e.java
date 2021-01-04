package com.baidu.swan.pms.c;

import android.text.TextUtils;
import com.baidu.fsg.base.statistics.j;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.swan.c.h;
import java.util.Map;
/* loaded from: classes6.dex */
public class e {
    public static String bgr() {
        return String.format("%s/getpkg", bgv());
    }

    public static String bgs() {
        return String.format("%s/updatecore", bgv());
    }

    public static String bgt() {
        return String.format("%s/fetchpkglist", bgv());
    }

    public static String bgu() {
        return String.format("%s/getplugin", bgv());
    }

    public static String bgv() {
        return com.baidu.swan.pms.d.bfV().aBy();
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
        String addParam = h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(str, "cuid", com.baidu.swan.pms.d.bfV().aBz()), "uuid", com.baidu.swan.pms.d.bfV().getUUID()), "ut", com.baidu.swan.pms.d.bfV().aBA()), j.c, h.zL(com.baidu.swan.pms.d.bfV().aBC())), "host_app", com.baidu.swan.pms.d.bfV().aBB()), "host_app_ver", com.baidu.swan.pms.d.bfV().aBC()), "host_os", com.baidu.swan.c.a.getOS()), "host_os_ver", com.baidu.swan.c.a.getOsVersion()), "network", com.baidu.swan.c.a.getNetworkInfo()), "sdk_ver", com.baidu.swan.pms.d.bfV().aBD());
        String bfU = com.baidu.swan.pms.d.bfW().bfU();
        if (!TextUtils.isEmpty(bfU)) {
            addParam = h.addParam(addParam, "extension_rule", bfU);
        }
        String aBJ = com.baidu.swan.pms.d.bfV().aBJ();
        if (!TextUtils.isEmpty(aBJ)) {
            return h.addParam(addParam, UbcStatConstant.KEY_CONTENT_EXT_SID, aBJ);
        }
        return addParam;
    }
}

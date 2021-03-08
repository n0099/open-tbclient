package com.baidu.swan.pms.c;

import android.text.TextUtils;
import com.baidu.fsg.base.statistics.j;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.swan.c.h;
import java.util.Map;
/* loaded from: classes3.dex */
public class e {
    public static String bcN() {
        return String.format("%s/getpkg", bcR());
    }

    public static String bcO() {
        return String.format("%s/updatecore", bcR());
    }

    public static String bcP() {
        return String.format("%s/fetchpkglist", bcR());
    }

    public static String bcQ() {
        return String.format("%s/getplugin", bcR());
    }

    public static String bcR() {
        return com.baidu.swan.pms.d.bcr().ayg();
    }

    public static String processUrl(String str) {
        return yi(str);
    }

    public static String i(String str, Map<String, String> map) {
        return j(yi(str), map);
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

    private static String yi(String str) {
        String addParam = h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(str, "cuid", com.baidu.swan.pms.d.bcr().ayh()), "uuid", com.baidu.swan.pms.d.bcr().getUUID()), "ut", com.baidu.swan.pms.d.bcr().ayi()), j.c, h.yZ(com.baidu.swan.pms.d.bcr().ayk())), "host_app", com.baidu.swan.pms.d.bcr().ayj()), "host_app_ver", com.baidu.swan.pms.d.bcr().ayk()), "host_os", com.baidu.swan.c.a.getOS()), "host_os_ver", com.baidu.swan.c.a.getOsVersion()), "network", com.baidu.swan.c.a.getNetworkInfo()), "sdk_ver", com.baidu.swan.pms.d.bcr().ayl());
        String bcq = com.baidu.swan.pms.d.bcs().bcq();
        if (!TextUtils.isEmpty(bcq)) {
            addParam = h.addParam(addParam, "extension_rule", bcq);
        }
        String ayr = com.baidu.swan.pms.d.bcr().ayr();
        if (!TextUtils.isEmpty(ayr)) {
            return h.addParam(addParam, UbcStatConstant.KEY_CONTENT_EXT_SID, ayr);
        }
        return addParam;
    }
}

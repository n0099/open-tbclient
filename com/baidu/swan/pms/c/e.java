package com.baidu.swan.pms.c;

import android.text.TextUtils;
import com.baidu.fsg.base.statistics.j;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.swan.e.i;
import java.util.Map;
/* loaded from: classes11.dex */
public class e {
    public static String aGn() {
        return String.format("%s/getpkg", aGr());
    }

    public static String aGo() {
        return String.format("%s/updatecore", aGr());
    }

    public static String aGp() {
        return String.format("%s/fetchpkglist", aGr());
    }

    public static String aGq() {
        return String.format("%s/getplugin", aGr());
    }

    public static String aGr() {
        return com.baidu.swan.pms.d.aFP().afQ();
    }

    public static String k(String str, Map<String, String> map) {
        return l(tk(str), map);
    }

    public static String l(String str, Map<String, String> map) {
        if (map != null) {
            for (String str2 : map.keySet()) {
                if (!TextUtils.isEmpty(map.get(str2))) {
                    str = i.addParam(str, str2, map.get(str2));
                }
            }
        }
        return str;
    }

    private static String tk(String str) {
        String addParam = i.addParam(i.addParam(i.addParam(i.addParam(i.addParam(i.addParam(i.addParam(i.addParam(i.addParam(i.addParam(str, "cuid", com.baidu.swan.pms.d.aFP().afR()), "uuid", com.baidu.swan.pms.d.aFP().getUUID()), "ut", com.baidu.swan.pms.d.aFP().afS()), j.c, i.ub(com.baidu.swan.pms.d.aFP().afU())), "host_app", com.baidu.swan.pms.d.aFP().afT()), "host_app_ver", com.baidu.swan.pms.d.aFP().afU()), "host_os", com.baidu.swan.e.a.getOS()), "host_os_ver", com.baidu.swan.e.a.getOsVersion()), "network", com.baidu.swan.e.a.getNetworkInfo()), "sdk_ver", com.baidu.swan.pms.d.aFP().afV());
        String aFN = com.baidu.swan.pms.d.aFQ().aFN();
        if (!TextUtils.isEmpty(aFN)) {
            addParam = i.addParam(addParam, "extension_rule", aFN);
        }
        String agb = com.baidu.swan.pms.d.aFP().agb();
        if (!TextUtils.isEmpty(agb)) {
            return i.addParam(addParam, UbcStatConstant.KEY_CONTENT_EXT_SID, agb);
        }
        return addParam;
    }
}

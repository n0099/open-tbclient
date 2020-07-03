package com.baidu.swan.pms.c;

import android.text.TextUtils;
import com.baidu.fsg.base.statistics.j;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.swan.e.i;
import java.util.Map;
/* loaded from: classes11.dex */
public class e {
    public static String aHt() {
        return String.format("%s/getpkg", aHx());
    }

    public static String aHu() {
        return String.format("%s/updatecore", aHx());
    }

    public static String aHv() {
        return String.format("%s/fetchpkglist", aHx());
    }

    public static String aHw() {
        return String.format("%s/getplugin", aHx());
    }

    public static String aHx() {
        return com.baidu.swan.pms.d.aGV().agW();
    }

    public static String k(String str, Map<String, String> map) {
        return l(ts(str), map);
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

    private static String ts(String str) {
        String addParam = i.addParam(i.addParam(i.addParam(i.addParam(i.addParam(i.addParam(i.addParam(i.addParam(i.addParam(i.addParam(str, "cuid", com.baidu.swan.pms.d.aGV().agX()), "uuid", com.baidu.swan.pms.d.aGV().getUUID()), "ut", com.baidu.swan.pms.d.aGV().agY()), j.c, i.uj(com.baidu.swan.pms.d.aGV().aha())), "host_app", com.baidu.swan.pms.d.aGV().agZ()), "host_app_ver", com.baidu.swan.pms.d.aGV().aha()), "host_os", com.baidu.swan.e.a.getOS()), "host_os_ver", com.baidu.swan.e.a.getOsVersion()), "network", com.baidu.swan.e.a.getNetworkInfo()), "sdk_ver", com.baidu.swan.pms.d.aGV().ahb());
        String aGT = com.baidu.swan.pms.d.aGW().aGT();
        if (!TextUtils.isEmpty(aGT)) {
            addParam = i.addParam(addParam, "extension_rule", aGT);
        }
        String ahh = com.baidu.swan.pms.d.aGV().ahh();
        if (!TextUtils.isEmpty(ahh)) {
            return i.addParam(addParam, UbcStatConstant.KEY_CONTENT_EXT_SID, ahh);
        }
        return addParam;
    }
}

package com.baidu.swan.pms.c;

import android.text.TextUtils;
import com.baidu.fsg.base.statistics.j;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.swan.d.h;
import java.util.Map;
/* loaded from: classes19.dex */
public class e {
    public static String aLk() {
        return String.format("%s/getpkg", aLo());
    }

    public static String aLl() {
        return String.format("%s/updatecore", aLo());
    }

    public static String aLm() {
        return String.format("%s/fetchpkglist", aLo());
    }

    public static String aLn() {
        return String.format("%s/getplugin", aLo());
    }

    public static String aLo() {
        return com.baidu.swan.pms.d.aKM().ail();
    }

    public static String processUrl(String str) {
        return uw(str);
    }

    public static String l(String str, Map<String, String> map) {
        return m(uw(str), map);
    }

    public static String m(String str, Map<String, String> map) {
        if (map != null) {
            for (String str2 : map.keySet()) {
                if (!TextUtils.isEmpty(map.get(str2))) {
                    str = h.addParam(str, str2, map.get(str2));
                }
            }
        }
        return str;
    }

    private static String uw(String str) {
        String addParam = h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(str, "cuid", com.baidu.swan.pms.d.aKM().aim()), "uuid", com.baidu.swan.pms.d.aKM().getUUID()), "ut", com.baidu.swan.pms.d.aKM().ain()), j.c, h.vm(com.baidu.swan.pms.d.aKM().aip())), "host_app", com.baidu.swan.pms.d.aKM().aio()), "host_app_ver", com.baidu.swan.pms.d.aKM().aip()), "host_os", com.baidu.swan.d.a.getOS()), "host_os_ver", com.baidu.swan.d.a.getOsVersion()), "network", com.baidu.swan.d.a.getNetworkInfo()), "sdk_ver", com.baidu.swan.pms.d.aKM().aiq());
        String aKK = com.baidu.swan.pms.d.aKN().aKK();
        if (!TextUtils.isEmpty(aKK)) {
            addParam = h.addParam(addParam, "extension_rule", aKK);
        }
        String aiw = com.baidu.swan.pms.d.aKM().aiw();
        if (!TextUtils.isEmpty(aiw)) {
            return h.addParam(addParam, UbcStatConstant.KEY_CONTENT_EXT_SID, aiw);
        }
        return addParam;
    }
}

package com.baidu.swan.pms.c;

import android.text.TextUtils;
import com.baidu.fsg.base.statistics.j;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.swan.c.h;
import java.util.Map;
/* loaded from: classes15.dex */
public class e {
    public static String bbx() {
        return String.format("%s/getpkg", bbB());
    }

    public static String bby() {
        return String.format("%s/updatecore", bbB());
    }

    public static String bbz() {
        return String.format("%s/fetchpkglist", bbB());
    }

    public static String bbA() {
        return String.format("%s/getplugin", bbB());
    }

    public static String bbB() {
        return com.baidu.swan.pms.d.bbb().axH();
    }

    public static String processUrl(String str) {
        return ys(str);
    }

    public static String k(String str, Map<String, String> map) {
        return l(ys(str), map);
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

    private static String ys(String str) {
        String addParam = h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(str, "cuid", com.baidu.swan.pms.d.bbb().axI()), "uuid", com.baidu.swan.pms.d.bbb().getUUID()), "ut", com.baidu.swan.pms.d.bbb().axJ()), j.c, h.zk(com.baidu.swan.pms.d.bbb().axL())), "host_app", com.baidu.swan.pms.d.bbb().axK()), "host_app_ver", com.baidu.swan.pms.d.bbb().axL()), "host_os", com.baidu.swan.c.a.getOS()), "host_os_ver", com.baidu.swan.c.a.getOsVersion()), "network", com.baidu.swan.c.a.getNetworkInfo()), "sdk_ver", com.baidu.swan.pms.d.bbb().axM());
        String bba = com.baidu.swan.pms.d.bbc().bba();
        if (!TextUtils.isEmpty(bba)) {
            addParam = h.addParam(addParam, "extension_rule", bba);
        }
        String axS = com.baidu.swan.pms.d.bbb().axS();
        if (!TextUtils.isEmpty(axS)) {
            return h.addParam(addParam, UbcStatConstant.KEY_CONTENT_EXT_SID, axS);
        }
        return addParam;
    }
}

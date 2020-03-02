package com.baidu.swan.pms.c;

import android.text.TextUtils;
import com.baidu.fsg.base.statistics.j;
import com.baidu.swan.d.h;
import java.util.Map;
/* loaded from: classes11.dex */
public class e {
    public static String atL() {
        return String.format("%s/getpkg", atP());
    }

    public static String atM() {
        return String.format("%s/updatecore", atP());
    }

    public static String atN() {
        return String.format("%s/fetchpkglist", atP());
    }

    public static String atO() {
        return String.format("%s/getplugin", atP());
    }

    public static String atP() {
        return com.baidu.swan.pms.d.atp().UR();
    }

    public static String g(String str, Map<String, String> map) {
        return h(qt(str), map);
    }

    public static String h(String str, Map<String, String> map) {
        if (map != null) {
            for (String str2 : map.keySet()) {
                if (!TextUtils.isEmpty(map.get(str2))) {
                    str = h.addParam(str, str2, map.get(str2));
                }
            }
        }
        return str;
    }

    private static String qt(String str) {
        String addParam = h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(str, "cuid", com.baidu.swan.pms.d.atp().US()), "uuid", com.baidu.swan.pms.d.atp().getUUID()), j.c, h.rk(com.baidu.swan.pms.d.atp().UU())), "host_app", com.baidu.swan.pms.d.atp().UT()), "host_app_ver", com.baidu.swan.pms.d.atp().UU()), "host_os", com.baidu.swan.d.a.getOS()), "host_os_ver", com.baidu.swan.d.a.getOsVersion()), "network", com.baidu.swan.d.a.getNetworkInfo()), "sdk_ver", com.baidu.swan.pms.d.atp().UV());
        String ato = com.baidu.swan.pms.d.atq().ato();
        if (!TextUtils.isEmpty(ato)) {
            addParam = h.addParam(addParam, "extension_rule", ato);
        }
        String Vb = com.baidu.swan.pms.d.atp().Vb();
        if (!TextUtils.isEmpty(Vb)) {
            return h.addParam(addParam, "sid", Vb);
        }
        return addParam;
    }
}

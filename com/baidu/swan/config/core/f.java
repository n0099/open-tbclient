package com.baidu.swan.config.core;

import com.baidu.fsg.base.statistics.j;
import com.baidu.swan.d.h;
/* loaded from: classes11.dex */
public class f {
    public static String processCommonParams(String str) {
        return h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(h.addParam(str, "cuid", com.baidu.swan.config.e.ajb().UV()), "uuid", com.baidu.swan.config.e.ajb().getUUID()), j.c, h.rj(com.baidu.swan.config.e.ajb().UX())), "host_os", com.baidu.swan.d.a.getOS()), "host_os_ver", com.baidu.swan.d.a.getOsVersion()), "network", com.baidu.swan.d.a.getNetworkInfo()), "host_app", com.baidu.swan.config.e.ajb().UW()), "host_app_ver", com.baidu.swan.config.e.ajb().UX()), "sdk_ver", com.baidu.swan.config.e.ajb().UY());
    }
}

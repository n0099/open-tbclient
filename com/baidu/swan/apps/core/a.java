package com.baidu.swan.apps.core;

import com.baidu.swan.apps.core.f;
/* loaded from: classes10.dex */
public class a {
    public static final String cto = String.format("FMP在%s毫秒内未到达", Integer.valueOf(f.a.ctG));
    public static final String ctp = "检测到白屏区域超过" + t(f.a.ctF);
    public static final String ctq = "检测到白屏区域超过" + t(f.a.ctE) + "且正在loading";
    public static final String cts = "请求失败率超过" + t(f.a.ctC);

    private static String t(double d) {
        return ((int) (100.0d * d)) + "%";
    }
}

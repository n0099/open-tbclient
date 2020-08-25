package com.baidu.swan.apps.core;

import com.baidu.swan.apps.core.f;
/* loaded from: classes8.dex */
public class a {
    public static final String ceS = String.format("FMP在%s毫秒内未到达", Integer.valueOf(f.a.cfj));
    public static final String ceT = "检测到白屏区域超过" + q(f.a.cfi);
    public static final String ceU = "检测到白屏区域超过" + q(f.a.cfh) + "且正在loading";
    public static final String ceV = "请求失败率超过" + q(f.a.cff);

    private static String q(double d) {
        return ((int) (100.0d * d)) + "%";
    }
}

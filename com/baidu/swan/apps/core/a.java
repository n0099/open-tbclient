package com.baidu.swan.apps.core;

import com.baidu.swan.apps.core.f;
/* loaded from: classes8.dex */
public class a {
    public static final String cQO = String.format("FMP在%s毫秒内未到达", Integer.valueOf(f.a.cRe));
    public static final String cQP = "检测到白屏区域超过" + n(f.a.cRd);
    public static final String cQQ = "检测到白屏区域超过" + n(f.a.cRc) + "且正在loading";
    public static final String cQR = "请求失败率超过" + n(f.a.cRa);

    private static String n(double d) {
        return ((int) (100.0d * d)) + "%";
    }
}

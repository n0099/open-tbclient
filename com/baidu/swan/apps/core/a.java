package com.baidu.swan.apps.core;

import com.baidu.swan.apps.core.f;
/* loaded from: classes10.dex */
public class a {
    public static final String cBO = String.format("FMP在%s毫秒内未到达", Integer.valueOf(f.a.cCe));
    public static final String cBP = "检测到白屏区域超过" + u(f.a.cCd);
    public static final String cBQ = "检测到白屏区域超过" + u(f.a.cCc) + "且正在loading";
    public static final String cBR = "请求失败率超过" + u(f.a.cCa);

    private static String u(double d) {
        return ((int) (100.0d * d)) + "%";
    }
}

package com.baidu.swan.apps.core;

import com.baidu.swan.apps.core.f;
/* loaded from: classes10.dex */
public class a {
    public static final String cHH = String.format("FMP在%s毫秒内未到达", Integer.valueOf(f.a.cHX));
    public static final String cHI = "检测到白屏区域超过" + u(f.a.cHW);
    public static final String cHJ = "检测到白屏区域超过" + u(f.a.cHV) + "且正在loading";
    public static final String cHK = "请求失败率超过" + u(f.a.cHT);

    private static String u(double d) {
        return ((int) (100.0d * d)) + "%";
    }
}

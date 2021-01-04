package com.baidu.swan.apps.core;

import com.baidu.swan.apps.core.f;
/* loaded from: classes9.dex */
public class a {
    public static final String cRM = String.format("FMP在%s毫秒内未到达", Integer.valueOf(f.a.cSc));
    public static final String cRN = "检测到白屏区域超过" + t(f.a.cSb);
    public static final String cRO = "检测到白屏区域超过" + t(f.a.cSa) + "且正在loading";
    public static final String cRP = "请求失败率超过" + t(f.a.cRY);

    private static String t(double d) {
        return ((int) (100.0d * d)) + "%";
    }
}

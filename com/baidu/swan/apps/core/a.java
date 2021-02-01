package com.baidu.swan.apps.core;

import com.baidu.swan.apps.core.f;
/* loaded from: classes9.dex */
public class a {
    public static final String cPo = String.format("FMP在%s毫秒内未到达", Integer.valueOf(f.a.cPE));
    public static final String cPp = "检测到白屏区域超过" + n(f.a.cPD);
    public static final String cPq = "检测到白屏区域超过" + n(f.a.cPC) + "且正在loading";
    public static final String cPr = "请求失败率超过" + n(f.a.cPA);

    private static String n(double d) {
        return ((int) (100.0d * d)) + "%";
    }
}

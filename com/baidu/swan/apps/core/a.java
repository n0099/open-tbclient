package com.baidu.swan.apps.core;

import com.baidu.swan.apps.core.f;
/* loaded from: classes7.dex */
public class a {
    public static final String cFX = String.format("FMP在%s毫秒内未到达", Integer.valueOf(f.a.cGn));
    public static final String cFY = "检测到白屏区域超过" + t(f.a.cGm);
    public static final String cFZ = "检测到白屏区域超过" + t(f.a.cGl) + "且正在loading";
    public static final String cGa = "请求失败率超过" + t(f.a.cGj);

    private static String t(double d) {
        return ((int) (100.0d * d)) + "%";
    }
}

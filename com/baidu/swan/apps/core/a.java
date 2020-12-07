package com.baidu.swan.apps.core;

import com.baidu.swan.apps.core.f;
/* loaded from: classes25.dex */
public class a {
    public static final String cMR = String.format("FMP在%s毫秒内未到达", Integer.valueOf(f.a.cNh));
    public static final String cMS = "检测到白屏区域超过" + t(f.a.cNg);
    public static final String cMT = "检测到白屏区域超过" + t(f.a.cNf) + "且正在loading";
    public static final String cMU = "请求失败率超过" + t(f.a.cNd);

    private static String t(double d) {
        return ((int) (100.0d * d)) + "%";
    }
}

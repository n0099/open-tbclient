package com.baidu.swan.apps.core;

import com.baidu.swan.apps.core.f;
/* loaded from: classes8.dex */
public class a {
    public static final String cNa = String.format("FMP在%s毫秒内未到达", Integer.valueOf(f.a.cNq));
    public static final String cNb = "检测到白屏区域超过" + n(f.a.cNp);
    public static final String cNc = "检测到白屏区域超过" + n(f.a.cNo) + "且正在loading";
    public static final String cNd = "请求失败率超过" + n(f.a.cNm);

    private static String n(double d) {
        return ((int) (100.0d * d)) + "%";
    }
}

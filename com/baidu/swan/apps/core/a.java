package com.baidu.swan.apps.core;

import com.baidu.swan.apps.core.f;
/* loaded from: classes8.dex */
public class a {
    public static final String ceW = String.format("FMP在%s毫秒内未到达", Integer.valueOf(f.a.cfn));
    public static final String ceX = "检测到白屏区域超过" + q(f.a.cfm);
    public static final String ceY = "检测到白屏区域超过" + q(f.a.cfl) + "且正在loading";
    public static final String ceZ = "请求失败率超过" + q(f.a.cfj);

    private static String q(double d) {
        return ((int) (100.0d * d)) + "%";
    }
}

package com.baidu.swan.apps.core;

import com.baidu.swan.apps.core.f;
/* loaded from: classes3.dex */
public class a {
    public static final String cgX = String.format("FMP在%s毫秒内未到达", Integer.valueOf(f.a.cho));
    public static final String cgY = "检测到白屏区域超过" + q(f.a.chn);
    public static final String cgZ = "检测到白屏区域超过" + q(f.a.chm) + "且正在loading";
    public static final String cha = "请求失败率超过" + q(f.a.chk);

    private static String q(double d) {
        return ((int) (100.0d * d)) + "%";
    }
}

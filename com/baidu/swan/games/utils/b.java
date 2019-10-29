package com.baidu.swan.games.utils;

import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes2.dex */
public class b {
    public static float Y(float f) {
        return f / AppRuntime.getAppContext().getResources().getDisplayMetrics().density;
    }

    public static int S(float f) {
        return (int) ((AppRuntime.getAppContext().getResources().getDisplayMetrics().density * f) + 0.5f);
    }
}

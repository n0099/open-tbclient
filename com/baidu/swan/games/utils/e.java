package com.baidu.swan.games.utils;

import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes10.dex */
public class e {
    public static float V(float f) {
        return f / AppRuntime.getAppContext().getResources().getDisplayMetrics().density;
    }

    public static int L(float f) {
        return (int) ((AppRuntime.getAppContext().getResources().getDisplayMetrics().density * f) + 0.5f);
    }
}

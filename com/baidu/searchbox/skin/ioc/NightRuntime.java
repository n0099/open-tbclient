package com.baidu.searchbox.skin.ioc;
/* loaded from: classes20.dex */
public class NightRuntime {
    private static DefaultNightContext sDefaultNightContext = new DefaultNightContext();

    public static INightContext getNightContext() {
        return sDefaultNightContext;
    }
}

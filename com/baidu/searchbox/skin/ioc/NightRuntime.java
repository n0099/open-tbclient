package com.baidu.searchbox.skin.ioc;
/* loaded from: classes19.dex */
public class NightRuntime {
    private static DefaultNightContext sDefaultNightContext = new DefaultNightContext();

    public static INightContext getNightContext() {
        return sDefaultNightContext;
    }
}

package com.baidu.searchbox.skin.ioc;
/* loaded from: classes20.dex */
public class SkinResourcesRuntime {
    private static DefaultSkinResourcesContext sDefaultSkinResourcesContext = new DefaultSkinResourcesContext();

    public static ISkinResourcesContext getSkinResourceContext() {
        return sDefaultSkinResourcesContext;
    }
}

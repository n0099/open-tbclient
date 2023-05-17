package com.baidu.searchbox.skin.ioc;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
@Autowired
/* loaded from: classes4.dex */
public class SkinResourcesRuntime {
    public static DefaultSkinResourcesContext sDefaultSkinResourcesContext = new DefaultSkinResourcesContext();

    @Inject(force = false)
    public static ISkinResourcesContext getSkinResourceContext() {
        return sDefaultSkinResourcesContext;
    }
}

package com.baidu.searchbox.skin.ioc;

import android.content.res.Resources;
import com.baidu.android.common.others.java.Pair;
/* loaded from: classes12.dex */
public class DefaultSkinResourcesContext implements ISkinResourcesContext {
    @Override // com.baidu.searchbox.skin.ioc.ISkinResourcesContext
    public Resources getSkinResources() {
        return null;
    }

    @Override // com.baidu.searchbox.skin.ioc.ISkinResourcesContext
    public Pair<Resources, Integer> getResIdPair(Resources resources, int i) {
        return new Pair<>(resources, Integer.valueOf(i));
    }
}

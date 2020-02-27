package com.baidu.searchbox.skin.ioc;

import android.content.res.Resources;
import com.baidu.android.common.others.java.Pair;
/* loaded from: classes13.dex */
public interface ISkinResourcesContext {
    Pair<Resources, Integer> getResIdPair(Resources resources, int i);

    Resources getSkinResources();
}

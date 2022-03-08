package com.baidu.nps.interfa;

import android.content.res.Resources;
/* loaded from: classes4.dex */
public interface IResourcesFetcher {
    Resources getBaseContextResources();

    Resources getGlobalResources();

    Resources[] getWrapperResources();
}

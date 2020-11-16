package com.baidu.ar.libloader;

import com.baidu.ar.callback.ICallback;
/* loaded from: classes12.dex */
public interface ILibLoaderPlugin {
    void onBeforeLoad(ICallback iCallback);

    boolean processLoadError(ICallback iCallback);
}

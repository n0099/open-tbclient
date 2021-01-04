package com.baidu.ar.libloader;

import com.baidu.ar.callback.ICallback;
/* loaded from: classes6.dex */
public interface ILibLoaderPlugin {
    void onBeforeLoad(ICallback iCallback);

    boolean processLoadError(ICallback iCallback);
}

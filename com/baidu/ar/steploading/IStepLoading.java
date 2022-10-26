package com.baidu.ar.steploading;

import com.baidu.ar.callback.ICallbackWith;
/* loaded from: classes.dex */
public interface IStepLoading {
    void cancel();

    void retry();

    void setLoadErrorListener(ICallbackWith iCallbackWith);
}

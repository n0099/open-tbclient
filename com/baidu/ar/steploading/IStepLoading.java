package com.baidu.ar.steploading;

import com.baidu.ar.callback.ICallbackWith;
/* loaded from: classes6.dex */
public interface IStepLoading {
    void cancel();

    void retry();

    void setLoadErrorListener(ICallbackWith<IStepLoading> iCallbackWith);
}

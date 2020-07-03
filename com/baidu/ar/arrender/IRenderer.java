package com.baidu.ar.arrender;

import com.baidu.ar.DuMixOutput;
import com.baidu.ar.DuMixStateListener;
import com.baidu.ar.arplay.core.filter.OnRenderFinishedListener;
import com.baidu.ar.arplay.core.filter.OnRenderStartedListener;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public interface IRenderer {
    void addOutputSurface(DuMixOutput duMixOutput);

    void cancelAysncRenderTask(Runnable runnable);

    void removeOutputSurface(DuMixOutput duMixOutput);

    void runAsyncOnRenderContext(Runnable runnable);

    void runSyncOnRenderContext(Runnable runnable);

    void setCameraSwitchListener(f fVar);

    void setRenderFinishedListener(OnRenderFinishedListener onRenderFinishedListener);

    void setRenderStartedListener(OnRenderStartedListener onRenderStartedListener);

    void setStateListener(DuMixStateListener duMixStateListener);
}

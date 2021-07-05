package com.baidu.ar.arrender;

import android.view.Surface;
/* loaded from: classes.dex */
public interface IGLRenderer extends IRenderer {
    void bindTargetSurface(Surface surface);

    Texture createTexture(int i2, int i3, int i4);

    void destroyTexture(Texture texture);

    void runSyncOnIOContext(Runnable runnable);

    void setInputTexture(int i2, int i3, int i4, int i5);

    void swapBuffer();
}

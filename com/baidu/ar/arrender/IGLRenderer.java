package com.baidu.ar.arrender;

import android.view.Surface;
/* loaded from: classes11.dex */
public interface IGLRenderer extends IRenderer {
    void bindTargetSurface(Surface surface);

    Texture createTexture(int i, int i2, int i3);

    void destroyTexture(Texture texture);

    void render();

    void runSyncOnIOContext(Runnable runnable);

    void setInputMatrix(float[] fArr);

    void setInputTexture(int i, int i2, int i3, int i4);

    void swapBuffer();
}

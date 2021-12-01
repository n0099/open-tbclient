package com.baidu.ar;

import android.graphics.SurfaceTexture;
import android.view.View;
import com.baidu.ar.arrender.FrameRenderListener;
/* loaded from: classes8.dex */
public interface IDuMix extends View.OnTouchListener {
    void addFrameRenderListener(FrameRenderListener frameRenderListener);

    void addOutput(DuMixOutput duMixOutput);

    void changeInputSize(int i2, int i3);

    void changeInputSize(SurfaceTexture surfaceTexture, int i2, int i3);

    void changeOutput(DuMixOutput duMixOutput);

    void changeOutputObject(Object obj, int i2, int i3);

    void changeOutputSize(int i2, int i3);

    void clearCase();

    void loadCase(ARType aRType, String str, String str2);

    void loadCase(String str, String str2);

    void pause();

    void pauseScene();

    void release();

    void removeFrameRenderListener(FrameRenderListener frameRenderListener);

    void removeOutput(DuMixOutput duMixOutput);

    void resume();

    void resumeScene();

    void setStateListener(DuMixStateListener duMixStateListener);

    void setup(DuMixInput duMixInput, DuMixOutput duMixOutput, DuMixCallback duMixCallback);
}

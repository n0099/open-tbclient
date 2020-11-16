package com.baidu.ar;

import android.graphics.SurfaceTexture;
import android.view.View;
/* loaded from: classes12.dex */
public interface IDuMix extends View.OnTouchListener {
    void changeInputSize(int i, int i2);

    void changeInputSize(SurfaceTexture surfaceTexture, int i, int i2);

    void changeOutput(DuMixOutput duMixOutput);

    void changeOutputSize(int i, int i2);

    void clearCase();

    void loadCase(ARType aRType, String str, String str2);

    void loadCase(String str, String str2);

    void pause();

    void pauseScene();

    void release();

    void resume();

    void resumeScene();

    void setStateListener(DuMixStateListener duMixStateListener);

    void setup(DuMixInput duMixInput, DuMixOutput duMixOutput, DuMixCallback duMixCallback);
}

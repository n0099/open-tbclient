package com.baidu.ar.draw;

import android.graphics.SurfaceTexture;
/* loaded from: classes3.dex */
public interface ARRenderCallback {
    void onARDrawerChanged(SurfaceTexture surfaceTexture, int i, int i2);

    void onARDrawerCreated(SurfaceTexture surfaceTexture, SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener, int i, int i2);

    void onCameraDrawerCreated(SurfaceTexture surfaceTexture, int i, int i2);
}

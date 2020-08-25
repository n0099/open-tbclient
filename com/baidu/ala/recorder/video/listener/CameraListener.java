package com.baidu.ala.recorder.video.listener;

import android.hardware.Camera;
/* loaded from: classes7.dex */
public interface CameraListener {
    ImageFilter getImageFilter();

    boolean onCameraOpen(Camera camera, int i);

    void onSurfaceChanged(int i, int i2);
}

package com.baidu.ala.liveRecorder.video.gles;
/* loaded from: classes6.dex */
public class OffscreenSurface extends EglSurfaceBase {
    public OffscreenSurface(EglCore eglCore, int i, int i2) {
        super(eglCore);
        createOffscreenSurface(i, i2);
    }

    public void release() {
        releaseEglSurface();
    }
}

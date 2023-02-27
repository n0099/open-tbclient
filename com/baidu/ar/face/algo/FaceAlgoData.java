package com.baidu.ar.face.algo;
/* loaded from: classes.dex */
public class FaceAlgoData {
    public FaceAlgoConfig mAlgoConfig;
    public FaceFrame mFaceFrame;

    public FaceAlgoConfig getAlgoConfig() {
        return this.mAlgoConfig;
    }

    public FaceFrame getFaceFrame() {
        return this.mFaceFrame;
    }

    public void setAlgoConfig(FaceAlgoConfig faceAlgoConfig) {
        this.mAlgoConfig = faceAlgoConfig;
    }

    public void setFaceFrame(FaceFrame faceFrame) {
        this.mFaceFrame = faceFrame;
    }
}

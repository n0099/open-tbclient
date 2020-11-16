package com.baidu.ar.face.algo;
/* loaded from: classes12.dex */
public class FaceAlgoConfig {
    boolean autoCalibrate;
    boolean debug;
    float eyeCloseProbThreshold;
    int failureThreshold;
    boolean forceLost;
    boolean isAnimojiMode;
    int maxTrackingFace;
    float minDetectionWidth;
    boolean mirror;
    boolean needExpression;
    boolean needHeadPose;
    boolean needRefineEyes;
    boolean needRefineIris;
    boolean needRefineMouth;
    boolean needSkeleton;
    boolean needTriggers;
    int runningMode;
    float trackingMouthSmoothAlpha;
    float trackingMouthThreshold;
    int trackingQuality;
    int trackingRotation;
    float trackingSmoothAlpha;
    float trackingSmoothThreshold;

    public FaceAlgoConfig(int i) {
        this.runningMode = 0;
        this.maxTrackingFace = 1;
        this.trackingRotation = -1;
        this.failureThreshold = 5;
        this.minDetectionWidth = 100.0f;
        this.trackingSmoothAlpha = 0.1f;
        this.trackingSmoothThreshold = 1.0f;
        this.trackingMouthThreshold = -1.0f;
        this.trackingMouthSmoothAlpha = 0.0075f;
        this.eyeCloseProbThreshold = -1.0f;
        this.mirror = true;
        this.isAnimojiMode = false;
        this.needRefineEyes = false;
        this.needRefineIris = false;
        this.needHeadPose = true;
        this.needSkeleton = true;
        this.needTriggers = true;
        this.forceLost = false;
        this.needRefineMouth = false;
        this.needExpression = false;
        this.debug = false;
        this.trackingRotation = i;
    }

    public FaceAlgoConfig(int i, int i2, float f, float f2) {
        this.runningMode = 0;
        this.maxTrackingFace = 1;
        this.trackingRotation = -1;
        this.failureThreshold = 5;
        this.minDetectionWidth = 100.0f;
        this.trackingSmoothAlpha = 0.1f;
        this.trackingSmoothThreshold = 1.0f;
        this.trackingMouthThreshold = -1.0f;
        this.trackingMouthSmoothAlpha = 0.0075f;
        this.eyeCloseProbThreshold = -1.0f;
        this.mirror = true;
        this.isAnimojiMode = false;
        this.needRefineEyes = false;
        this.needRefineIris = false;
        this.needHeadPose = true;
        this.needSkeleton = true;
        this.needTriggers = true;
        this.forceLost = false;
        this.needRefineMouth = false;
        this.needExpression = false;
        this.debug = false;
        this.trackingRotation = i;
        this.failureThreshold = i2;
        this.trackingSmoothAlpha = f;
        this.trackingSmoothThreshold = f2;
    }

    public FaceAlgoConfig cloneInstance() {
        FaceAlgoConfig faceAlgoConfig = new FaceAlgoConfig(this.trackingRotation, this.failureThreshold, this.trackingSmoothAlpha, this.trackingSmoothThreshold);
        faceAlgoConfig.setAnimateRunningMode(this.needHeadPose, this.needSkeleton, this.needTriggers);
        faceAlgoConfig.setAutoCalibrate(this.autoCalibrate);
        faceAlgoConfig.setRunningMode(this.runningMode);
        faceAlgoConfig.setMirror(this.mirror);
        faceAlgoConfig.setIsAnimojiMode(this.isAnimojiMode);
        faceAlgoConfig.setMaxTrackingFace(this.maxTrackingFace);
        faceAlgoConfig.setNeedRefineEyes(this.needRefineEyes);
        faceAlgoConfig.setForceLost(this.forceLost);
        faceAlgoConfig.setNeedRefineMouth(this.needRefineMouth);
        faceAlgoConfig.setNeedExpression(this.needExpression);
        faceAlgoConfig.setTrackingMouthThreshold(this.trackingMouthThreshold);
        faceAlgoConfig.setTrackingMouthSmoothAlpha(this.trackingMouthSmoothAlpha);
        return faceAlgoConfig;
    }

    public void setAnimateRunningMode(boolean z, boolean z2, boolean z3) {
        this.needHeadPose = z;
        this.needSkeleton = z2;
        this.needTriggers = z3;
    }

    public void setAutoCalibrate(boolean z) {
        this.autoCalibrate = z;
    }

    public void setDebug(boolean z) {
        this.debug = z;
    }

    public void setEyeCloseProbThreshold(float f) {
        this.eyeCloseProbThreshold = f;
    }

    public void setFailureThreshold(int i) {
        this.failureThreshold = i;
    }

    public void setForceLost(boolean z) {
        this.forceLost = z;
    }

    public void setIsAnimojiMode(boolean z) {
        this.isAnimojiMode = z;
    }

    public void setMaxTrackingFace(int i) {
        this.maxTrackingFace = i;
    }

    public void setMirror(boolean z) {
        this.mirror = z;
    }

    public void setNeedExpression(boolean z) {
        this.needExpression = z;
    }

    public void setNeedHeadPose(boolean z) {
        this.needHeadPose = z;
    }

    public void setNeedRefineEyes(boolean z) {
        this.needRefineEyes = z;
        this.needRefineIris = z;
    }

    public void setNeedRefineMouth(boolean z) {
        this.needRefineMouth = z;
    }

    public void setNeedSkeleton(boolean z) {
        this.needSkeleton = z;
    }

    public void setNeedTriggers(boolean z) {
        this.needTriggers = z;
    }

    public void setRunningMode(int i) {
        this.runningMode = i;
    }

    public void setTrackingMouthSmoothAlpha(float f) {
        this.trackingMouthSmoothAlpha = f;
    }

    public void setTrackingMouthThreshold(float f) {
        this.trackingMouthThreshold = f;
    }

    public void setTrackingRT(int i) {
        this.trackingRotation = i;
    }

    public void setTrackingSmoothAlpha(float f) {
        this.trackingSmoothAlpha = f;
    }

    public void setTrackingSmoothThreshold(float f) {
        this.trackingSmoothThreshold = f;
    }
}

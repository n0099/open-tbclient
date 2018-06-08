package com.baidu.ar.camera;
/* loaded from: classes3.dex */
public class CameraParams {
    private static final double DEFAULT_ASPECT_TOLERANCE = 0.05d;
    private static final boolean DEFAULT_AUTO_CORRECT_PARAMS = true;
    private static final boolean DEFAULT_AUTO_FOCUS = true;
    private static final int DEFAULT_CAMERA_INDEX = 0;
    private static final boolean DEFAULT_FRAME_RATE_CORRECT_UPWARD = false;
    private static final boolean DEFAULT_KEEP_ASPECT_RATIO = true;
    private static final boolean DEFAULT_PICTURE_CORRECT_UPWARD = true;
    private static final int DEFAULT_PICTURE_HEIGHT = 720;
    private static final int DEFAULT_PICTURE_WIDTH = 1280;
    private static final boolean DEFAULT_PREVIEW_CORRECT_UPWARD = false;
    private static final int DEFAULT_PREVIEW_FRAME_RATE = 30;
    private static final int DEFAULT_PREVIEW_HEIGHT = 720;
    private static final int DEFAULT_PREVIEW_WIDTH = 1280;
    private static final int DEFAULT_ROTATE_DEGREE = 90;
    private int mCameraId = 0;
    private boolean mAutoCorrectParams = true;
    private boolean mKeepAspectRatio = true;
    private double mAspectTolerance = DEFAULT_ASPECT_TOLERANCE;
    private int mPreviewWidth = 1280;
    private int mPreviewHeight = 720;
    private boolean mPreviewCorrectUpward = false;
    private int mFrameRate = 30;
    private boolean mFrameRateCorrectUpward = false;
    private boolean mAutoFocus = true;
    private int mRotateDegree = 90;
    private int mPictureWidth = 1280;
    private int mPictureHeight = 720;
    private boolean mPictureCorrectUpward = true;

    public double getAspectTolerance() {
        return this.mAspectTolerance;
    }

    public int getCameraId() {
        return this.mCameraId;
    }

    public int getFrameRate() {
        return this.mFrameRate;
    }

    public int getPictureHeight() {
        return this.mPictureHeight;
    }

    public int getPictureWidth() {
        return this.mPictureWidth;
    }

    public int getPreviewHeight() {
        return this.mPreviewHeight;
    }

    public int getPreviewWidth() {
        return this.mPreviewWidth;
    }

    public int getRotateDegree() {
        return this.mRotateDegree;
    }

    public boolean isAutoCorrectParams() {
        return this.mAutoCorrectParams;
    }

    public boolean isAutoFocus() {
        return this.mAutoFocus;
    }

    public boolean isFrameRateCorrectUpward() {
        return this.mFrameRateCorrectUpward;
    }

    public boolean isKeepAspectRatio() {
        return this.mKeepAspectRatio;
    }

    public boolean isPictureCorrectUpward() {
        return this.mPictureCorrectUpward;
    }

    public boolean isPreviewCorrectUpward() {
        return this.mPreviewCorrectUpward;
    }

    public void setAspectTolerance(double d) {
        this.mAspectTolerance = d;
    }

    public void setAutoCorrectParams(boolean z) {
        this.mAutoCorrectParams = z;
    }

    public void setAutoFocus(boolean z) {
        this.mAutoFocus = z;
    }

    public void setCameraId(int i) {
        this.mCameraId = i;
    }

    public void setFrameRate(int i) {
        this.mFrameRate = i;
    }

    public void setFrameRateCorrectUpward(boolean z) {
        this.mFrameRateCorrectUpward = z;
    }

    public void setKeepAspectRatio(boolean z) {
        this.mKeepAspectRatio = z;
    }

    public void setPictureCorrectUpward(boolean z) {
        this.mPictureCorrectUpward = z;
    }

    public void setPictureHeight(int i) {
        this.mPictureHeight = i;
    }

    public void setPictureWidth(int i) {
        this.mPictureWidth = i;
    }

    public void setPreviewCorrectUpward(boolean z) {
        this.mPreviewCorrectUpward = z;
    }

    public void setPreviewHeight(int i) {
        this.mPreviewHeight = i;
    }

    public void setPreviewWidth(int i) {
        this.mPreviewWidth = i;
    }

    public void setRotateDegree(int i) {
        this.mRotateDegree = i;
    }
}

package com.baidu.ar.arplay.core.pixel;

import android.graphics.Rect;
import com.baidu.ar.arplay.core.pixel.PixelReadParams;
/* loaded from: classes.dex */
public class ReadParams {
    public static final int DEFAULT_CACHE_SIZE = 3;
    public static final int DEFAULT_ROTATE_DEGREE = 0;
    public PixelType mPixelType;
    public Rect mReadRect;
    public FrameSize mTargetFrameSize;
    public static final PixelReadParams.ScaleType DEFAULT_SCALE_TYPE = PixelReadParams.ScaleType.FIT_XY;
    public static final MirrorType DEFAULT_MIRROR_TYPE = MirrorType.NO_MIRROR;
    public PixelReadParams.ScaleType mScaleType = DEFAULT_SCALE_TYPE;
    public MirrorType mMirrorType = DEFAULT_MIRROR_TYPE;
    public int mRotateDegree = 0;
    public boolean mUsePBO = true;
    public int mCacheSize = 3;

    public ReadParams(PixelType pixelType) {
        this.mPixelType = pixelType;
    }

    public int getCacheSize() {
        return this.mCacheSize;
    }

    public MirrorType getMirrorType() {
        return this.mMirrorType;
    }

    public PixelType getPixelType() {
        return this.mPixelType;
    }

    public Rect getReadRect() {
        return this.mReadRect;
    }

    public int getRotateDegree() {
        return this.mRotateDegree;
    }

    public PixelReadParams.ScaleType getScaleType() {
        return this.mScaleType;
    }

    public FrameSize getTargetFrameSize() {
        return this.mTargetFrameSize;
    }

    public boolean isUsePBO() {
        return this.mUsePBO;
    }

    public void setCacheSize(int i) {
        this.mCacheSize = i;
    }

    public void setMirrorType(MirrorType mirrorType) {
        this.mMirrorType = mirrorType;
    }

    public void setPixelType(PixelType pixelType) {
        this.mPixelType = pixelType;
    }

    public void setReadRect(Rect rect) {
        this.mReadRect = rect;
    }

    public void setRotateDegree(int i) {
        this.mRotateDegree = i;
    }

    public void setScaleType(PixelReadParams.ScaleType scaleType) {
        this.mScaleType = scaleType;
    }

    public void setTargetFrameSize(FrameSize frameSize) {
        this.mTargetFrameSize = frameSize;
    }

    public void setUsePBO(boolean z) {
        this.mUsePBO = z;
    }
}

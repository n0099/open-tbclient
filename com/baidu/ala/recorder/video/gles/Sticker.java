package com.baidu.ala.recorder.video.gles;

import android.graphics.Bitmap;
import android.graphics.RectF;
import android.opengl.Matrix;
/* loaded from: classes6.dex */
public class Sticker {
    private Bitmap mBmp;
    private int mCameraHeight;
    private int mCameraWidth;
    private RectF mSceenRectF;
    private int mScreenHeight;
    private int mScreenWidth;
    private RectF mStickerRectF;
    private int mTextureId;
    private float mScaleX = 1.0f;
    private float mScaleY = 1.0f;
    private float[] mStickerMatrix = new float[16];

    public Sticker() {
        Matrix.setIdentityM(this.mStickerMatrix, 0);
        setStickerMtrix(this.mStickerMatrix);
    }

    private void updateMatrix() {
        float f;
        float f2;
        this.mScaleX = 1.0f;
        this.mScaleY = this.mScreenHeight / this.mScreenWidth;
        if (this.mScreenWidth < this.mScreenHeight) {
            f = this.mScreenWidth / this.mScreenHeight;
            f2 = 1.0f;
        } else if (this.mScreenWidth > this.mScreenHeight) {
            f2 = this.mScreenHeight / this.mScreenWidth;
            f = 1.0f;
        } else {
            f = 1.0f;
            f2 = 1.0f;
        }
        setScale(this.mScaleX * f2, f * this.mScaleY);
    }

    public synchronized void setBitmap(Bitmap bitmap) {
        this.mBmp = bitmap;
    }

    public synchronized Bitmap popBitmap() {
        Bitmap bitmap;
        bitmap = this.mBmp;
        this.mBmp = null;
        return bitmap;
    }

    public synchronized void recycle() {
        Bitmap bitmap = this.mBmp;
        this.mBmp = null;
        if (bitmap != null) {
            bitmap.recycle();
        }
    }

    public int getTexture() {
        return this.mTextureId;
    }

    public float[] getMatrix() {
        return this.mStickerMatrix;
    }

    public void setStickerMtrix(float[] fArr) {
        this.mStickerMatrix = fArr;
    }

    public void setTexutureId(int i) {
        this.mTextureId = i;
    }

    public void setScale(float f, float f2) {
        Matrix.setIdentityM(this.mStickerMatrix, 0);
        Matrix.scaleM(this.mStickerMatrix, 0, 1.0f / f, 1.0f / f2, 1.0f);
        Matrix.translateM(this.mStickerMatrix, 0, (-(1.0f - f)) / 2.0f, (-(1.0f - f2)) / 2.0f, 0.0f);
    }

    public void setCameraSize(int i, int i2) {
        if (this.mCameraWidth != i || this.mCameraHeight != i2) {
            this.mCameraWidth = i;
            this.mCameraHeight = i2;
            updateMatrix();
        }
    }

    public void setScreenSize(int i, int i2) {
        if (this.mScreenWidth != i || this.mScreenHeight != i2) {
            this.mScreenWidth = i;
            this.mScreenHeight = i2;
            updateMatrix();
        }
    }
}

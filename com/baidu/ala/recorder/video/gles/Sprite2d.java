package com.baidu.ala.recorder.video.gles;

import android.opengl.Matrix;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes7.dex */
public class Sprite2d {
    private static final String TAG = "Grafika";
    private float mAngle;
    private Drawable2d mDrawable;
    private boolean mMatrixReady;
    private float[] mModelViewMatrix;
    private float mPosX;
    private float mPosY;
    private float mScaleX;
    private float mScaleY;
    private int mTextureId;
    private float[] mScratchMatrix = new float[16];
    private float[] mColor = new float[4];

    public Sprite2d(Drawable2d drawable2d) {
        this.mDrawable = drawable2d;
        this.mColor[3] = 1.0f;
        this.mTextureId = -1;
        this.mModelViewMatrix = new float[16];
        this.mMatrixReady = false;
    }

    private void recomputeMatrix() {
        float[] fArr = this.mModelViewMatrix;
        Matrix.setIdentityM(fArr, 0);
        Matrix.translateM(fArr, 0, this.mPosX, this.mPosY, 0.0f);
        if (this.mAngle != 0.0f) {
            Matrix.rotateM(fArr, 0, this.mAngle, 0.0f, 0.0f, 1.0f);
        }
        Matrix.scaleM(fArr, 0, this.mScaleX, this.mScaleY, 1.0f);
        this.mMatrixReady = true;
    }

    public float getScaleX() {
        return this.mScaleX;
    }

    public float getScaleY() {
        return this.mScaleY;
    }

    public void setScale(float f, float f2) {
        this.mScaleX = f;
        this.mScaleY = f2;
        this.mMatrixReady = false;
    }

    public float getRotation() {
        return this.mAngle;
    }

    public void setRotation(float f) {
        float f2 = f;
        while (f2 >= 360.0f) {
            f2 -= 360.0f;
        }
        while (f2 <= -360.0f) {
            f2 += 360.0f;
        }
        this.mAngle = f2;
        this.mMatrixReady = false;
    }

    public float getPositionX() {
        return this.mPosX;
    }

    public float getPositionY() {
        return this.mPosY;
    }

    public void setPosition(float f, float f2) {
        this.mPosX = f;
        this.mPosY = f2;
        this.mMatrixReady = false;
    }

    public float[] getModelViewMatrix() {
        if (!this.mMatrixReady) {
            recomputeMatrix();
        }
        return this.mModelViewMatrix;
    }

    public void setColor(float f, float f2, float f3) {
        this.mColor[0] = f;
        this.mColor[1] = f2;
        this.mColor[2] = f3;
    }

    public void setTexture(int i) {
        this.mTextureId = i;
    }

    public float[] getColor() {
        return this.mColor;
    }

    public void draw(FlatShadedProgram flatShadedProgram, float[] fArr) {
        Matrix.multiplyMM(this.mScratchMatrix, 0, fArr, 0, getModelViewMatrix(), 0);
        flatShadedProgram.draw(this.mScratchMatrix, this.mColor, this.mDrawable.getVertexArray(), 0, this.mDrawable.getVertexCount(), this.mDrawable.getCoordsPerVertex(), this.mDrawable.getVertexStride());
    }

    public void draw(Texture2dProgram texture2dProgram, float[] fArr) {
        Matrix.multiplyMM(this.mScratchMatrix, 0, fArr, 0, getModelViewMatrix(), 0);
        texture2dProgram.draw(this.mScratchMatrix, this.mDrawable.getVertexArray(), 0, this.mDrawable.getVertexCount(), this.mDrawable.getCoordsPerVertex(), this.mDrawable.getVertexStride(), GlUtil.IDENTITY_MATRIX, this.mDrawable.getTexCoordArray(), this.mTextureId, this.mDrawable.getTexCoordStride());
    }

    public String toString() {
        return "[Sprite2d pos=" + this.mPosX + Constants.ACCEPT_TIME_SEPARATOR_SP + this.mPosY + " scale=" + this.mScaleX + Constants.ACCEPT_TIME_SEPARATOR_SP + this.mScaleY + " angle=" + this.mAngle + " color={" + this.mColor[0] + Constants.ACCEPT_TIME_SEPARATOR_SP + this.mColor[1] + Constants.ACCEPT_TIME_SEPARATOR_SP + this.mColor[2] + "} drawable=" + this.mDrawable + "]";
    }
}

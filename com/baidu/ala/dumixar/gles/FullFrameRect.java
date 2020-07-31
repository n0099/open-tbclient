package com.baidu.ala.dumixar.gles;

import android.opengl.Matrix;
import com.baidu.ala.dumixar.gles.Drawable2d;
/* loaded from: classes7.dex */
public class FullFrameRect {
    private float mAngle;
    private Texture2dProgram mProgram;
    private final Drawable2d mRectDrawable = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
    private float[] mMvpMtx = GlUtil.IDENTITY_MATRIX;
    private float mScaleX = 1.0f;
    private float mScaleY = 1.0f;
    private float[] mScratchMatrix = new float[16];
    private float[] mModelViewMatrix = new float[16];

    public FullFrameRect(Texture2dProgram texture2dProgram) {
        this.mProgram = texture2dProgram;
    }

    public void release(boolean z) {
        if (this.mProgram != null) {
            if (z) {
                this.mProgram.release();
            }
            this.mProgram = null;
        }
    }

    public void setMirror(boolean z) {
        this.mScaleX = z ? this.mScaleX * (-1.0f) : this.mScaleX;
    }

    public void setScale(float f, float f2) {
        this.mRectDrawable.setScale(f, f2);
    }

    public void setScaleAndTranslate(float f, float f2, float f3, float f4) {
        this.mRectDrawable.setScaleAndTranslate(f, f2, f3, f4);
    }

    public void setVertexPoint(float[] fArr) {
        this.mMvpMtx = fArr;
    }

    public Texture2dProgram getProgram() {
        return this.mProgram;
    }

    public void changeProgram(Texture2dProgram texture2dProgram) {
        this.mProgram.release();
        this.mProgram = texture2dProgram;
    }

    public int createTextureObject() {
        return this.mProgram.createTextureObject();
    }

    public int createTexture2DObject() {
        return this.mProgram.createTexture2DObject();
    }

    public void drawFrame(int i, float[] fArr) {
        drawFrame(i, fArr, false);
    }

    public void drawFrame(int i, float[] fArr, boolean z) {
        if (this.mProgram != null) {
            float[] fArr2 = this.mMvpMtx;
            if (z) {
                Matrix.multiplyMM(this.mScratchMatrix, 0, fArr2, 0, getModelViewMatrix(), 0);
            } else if (this.mAngle != 0.0f) {
                Matrix.multiplyMM(this.mScratchMatrix, 0, fArr2, 0, getModelViewMatrix(), 0);
            } else {
                this.mScratchMatrix = fArr2;
            }
            this.mProgram.draw(this.mScratchMatrix, this.mRectDrawable.getVertexArray(), 0, this.mRectDrawable.getVertexCount(), this.mRectDrawable.getCoordsPerVertex(), this.mRectDrawable.getVertexStride(), fArr, this.mRectDrawable.getTexCoordArray(), i, this.mRectDrawable.getTexCoordStride());
        }
    }

    public void drawFrame(int i, float[] fArr, int i2, float[] fArr2) {
        drawFrame(i, fArr, i2, fArr2, false);
    }

    public void drawFrame(int i, float[] fArr, int i2, float[] fArr2, boolean z) {
        if (this.mProgram != null) {
            float[] fArr3 = GlUtil.IDENTITY_MATRIX;
            if (z) {
                this.mScaleX = -1.0f;
                this.mAngle = 180.0f;
                Matrix.multiplyMM(this.mScratchMatrix, 0, fArr3, 0, getModelViewMatrix(), 0);
            } else if (this.mAngle != 0.0f) {
                Matrix.multiplyMM(this.mScratchMatrix, 0, fArr3, 0, getModelViewMatrix(), 0);
            } else {
                this.mScratchMatrix = fArr3;
            }
            this.mProgram.draw(this.mScratchMatrix, this.mRectDrawable.getVertexArray(), 0, this.mRectDrawable.getVertexCount(), this.mRectDrawable.getCoordsPerVertex(), this.mRectDrawable.getVertexStride(), fArr, this.mRectDrawable.getTexCoordArray(), i, this.mRectDrawable.getTexCoordStride(), i2, fArr2, this.mRectDrawable.getTexCoordArray2());
        }
    }

    public float[] getModelViewMatrix() {
        recomputeMatrix();
        return this.mModelViewMatrix;
    }

    private void recomputeMatrix() {
        float[] fArr = this.mModelViewMatrix;
        Matrix.setIdentityM(fArr, 0);
        if (this.mAngle != 0.0f) {
            Matrix.rotateM(fArr, 0, this.mAngle, 0.0f, 0.0f, 1.0f);
        }
        Matrix.scaleM(fArr, 0, this.mScaleX, this.mScaleY, 1.0f);
    }

    public void setAngle(float f) {
        this.mAngle = f;
    }

    public void setShaderBgColor(String str) {
        if (this.mProgram != null) {
            this.mProgram.setShaderBgColor(str);
        }
    }

    public void setHumanSegMaskParams(int i, String str, float f) {
        if (this.mProgram != null) {
            this.mProgram.setHumanSegMaskParams(i, str, f);
        }
    }

    public void setAlpha(float f) {
        if (this.mProgram != null) {
            this.mProgram.setAlpha(f);
        }
    }

    public void setDxDy(float f, float f2) {
        if (this.mProgram != null) {
            this.mProgram.setDxDy(f, f2);
        }
    }

    public void setDistance(float f) {
        if (this.mProgram != null) {
            this.mProgram.setDistance(f);
        }
    }
}

package com.baidu.ala.recorder.video.gles;

import com.baidu.ala.recorder.video.gles.Drawable2d;
import java.nio.FloatBuffer;
/* loaded from: classes3.dex */
public class FullFrameRect2 {
    private Texture2dProgram mProgram;
    private final Drawable2d mRectDrawable = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
    private FloatBuffer mVertexArrayBuffer;

    public FullFrameRect2(Texture2dProgram texture2dProgram) {
        this.mVertexArrayBuffer = null;
        this.mProgram = texture2dProgram;
        this.mVertexArrayBuffer = this.mRectDrawable.getVertexArray().duplicate();
    }

    public void release(boolean z) {
        if (this.mProgram != null) {
            if (z) {
                this.mProgram.release();
            }
            this.mProgram = null;
        }
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

    public void drawFrame(int i, float[] fArr) {
        this.mProgram.draw(GlUtil.IDENTITY_MATRIX, this.mRectDrawable.getVertexArray(), 0, this.mRectDrawable.getVertexCount(), this.mRectDrawable.getCoordsPerVertex(), this.mRectDrawable.getVertexStride(), fArr, this.mRectDrawable.getTexCoordArray(), i, this.mRectDrawable.getTexCoordStride());
    }

    public void resetVertexArray(float[] fArr) {
        if (fArr != null) {
            this.mVertexArrayBuffer = GlUtil.createFloatBuffer(fArr);
        }
    }

    public int getVertexCount() {
        if (this.mRectDrawable != null) {
            return this.mRectDrawable.getVertexCount();
        }
        return 0;
    }

    public void drawFrame2(int i, float[] fArr) {
        if (this.mProgram != null && this.mVertexArrayBuffer != null) {
            this.mProgram.draw(GlUtil.IDENTITY_MATRIX, this.mVertexArrayBuffer, 0, this.mRectDrawable.getVertexCount(), this.mRectDrawable.getCoordsPerVertex(), this.mRectDrawable.getVertexStride(), fArr, this.mRectDrawable.getTexCoordArray(), i, this.mRectDrawable.getTexCoordStride());
        }
    }
}

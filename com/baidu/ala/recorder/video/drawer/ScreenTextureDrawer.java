package com.baidu.ala.recorder.video.drawer;

import android.annotation.TargetApi;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Log;
import android.view.Surface;
import com.baidu.ala.helper.AlaLiveUtilHelper;
import com.baidu.ala.recorder.video.gles.AFullFrameRect;
import com.baidu.ala.recorder.video.gles.EglCore;
import com.baidu.ala.recorder.video.gles.GlUtil;
import com.baidu.ala.recorder.video.gles.Texture2dProgram;
import com.baidu.ala.recorder.video.gles.WindowSurface;
@TargetApi(16)
/* loaded from: classes6.dex */
public class ScreenTextureDrawer {
    public static final String TAG = ScreenTextureDrawer.class.getSimpleName();
    private static final boolean mVideoModelFit = false;
    private boolean mCreateSucc;
    private int mInputHeight;
    private int mInputWidth;
    private int mSurfaceHeight;
    private int mSurfaceWidth;
    private float[] mIdentityMatrix = new float[16];
    private int mDropFrames = 0;
    private EglCore mEglCore = null;
    private WindowSurface mSurface = null;
    private AFullFrameRect mFullScreen = null;

    public ScreenTextureDrawer() {
        this.mCreateSucc = false;
        this.mSurfaceWidth = 0;
        this.mSurfaceHeight = 0;
        this.mInputWidth = 0;
        this.mInputHeight = 0;
        this.mSurfaceWidth = 0;
        this.mSurfaceHeight = 0;
        this.mInputWidth = 0;
        this.mInputHeight = 0;
        Matrix.setIdentityM(this.mIdentityMatrix, 0);
        this.mCreateSucc = false;
    }

    public void onSurfaceCreate(EglCore eglCore, Surface surface) {
        boolean z = false;
        boolean z2 = true;
        surfaceDestroy();
        this.mEglCore = eglCore;
        this.mSurface = new WindowSurface(this.mEglCore, surface, false);
        try {
            this.mSurface.makeCurrent();
            this.mFullScreen = new AFullFrameRect(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
            GlUtil.checkGlError("onSurfaceCreate AFullFrameRect create");
            if (this.mSurfaceWidth == 0) {
                this.mSurfaceWidth = this.mSurface.getWidth();
                z = true;
            }
            if (this.mSurfaceHeight == 0) {
                this.mSurfaceHeight = this.mSurface.getHeight();
            } else {
                z2 = z;
            }
            if (z2) {
                resetVertexMatrix();
            }
            this.mCreateSucc = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onSurfaceChanged(int i, int i2) {
        Log.e(TAG, "onSurfaceChanged width | " + i + " height | " + i2);
        this.mSurfaceWidth = i;
        this.mSurfaceHeight = i2;
        resetVertexMatrix();
        this.mDropFrames = 1;
    }

    public void onInputSize(int i, int i2) {
        boolean z = false;
        z = (this.mInputWidth == 0 || this.mInputHeight == 0) ? true : true;
        this.mInputWidth = i;
        this.mInputHeight = i2;
        if (z) {
            resetVertexMatrix();
        }
    }

    public void onSurfaceDestroy() {
    }

    public boolean isCreated() {
        return this.mCreateSucc;
    }

    public void makeContext() {
        if (this.mSurface != null) {
            try {
                this.mSurface.makeCurrent();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void drawFrame(int i) {
        drawFrame(i, this.mIdentityMatrix);
    }

    public void drawFrame(int i, float[] fArr) {
        if (i >= 0) {
            try {
                if (this.mSurfaceWidth == 0) {
                    this.mSurfaceWidth = this.mSurface.getWidth();
                }
                if (this.mSurfaceHeight == 0) {
                    this.mSurfaceHeight = this.mSurface.getHeight();
                }
                this.mSurface.makeCurrent();
                GLES20.glBindFramebuffer(36160, 0);
                GlUtil.checkGlError("glBindFramebuffer");
                GLES20.glViewport(0, 0, this.mSurfaceWidth, this.mSurfaceHeight);
                if (this.mDropFrames > 0) {
                    Log.e(TAG, "drawFrame => mDropFrames " + this.mDropFrames);
                    this.mSurface.swapBuffers();
                    this.mSurface.makeCurrent();
                    this.mDropFrames--;
                    return;
                }
                GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
                this.mFullScreen.drawFrame2(i, fArr);
                GlUtil.checkGlError("drawFrame2 done");
                if (!this.mSurface.swapBuffers()) {
                    Log.e(TAG, "mSurface.swapBuffers failed");
                }
                this.mSurface.makeCurrent();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public int getSurfaceWidth() {
        return this.mSurfaceWidth;
    }

    public int getSurfaceheight() {
        return this.mSurfaceHeight;
    }

    public void onRelease() {
        surfaceDestroy();
        fullScreenDestroy();
    }

    private void resetVertexMatrix() {
        if (this.mInputHeight == 0 || this.mInputWidth == 0 || this.mSurfaceWidth == 0 || this.mSurfaceHeight == 0) {
            Log.e(TAG, "resetVertexMatrix params error");
        } else if (this.mFullScreen != null && this.mFullScreen.getVertexCount() == 4) {
            boolean z = this.mSurfaceWidth > this.mSurfaceHeight;
            float f = z ? this.mInputHeight : this.mInputWidth;
            float f2 = z ? this.mInputWidth : this.mInputHeight;
            float[] vertexArray = AlaLiveUtilHelper.getVertexArray(this.mSurfaceWidth, this.mSurfaceHeight, f, f2, false);
            Log.e(TAG, "resetVertexMatrix mSurfaceWidth: " + this.mSurfaceWidth + " mSurfaceHeight: " + this.mSurfaceHeight + " sourceWidth: " + f + " sourceHeight: " + f2);
            this.mFullScreen.resetVertexArray(vertexArray);
        }
    }

    private void surfaceDestroy() {
        if (this.mSurface != null) {
            try {
                this.mSurface.release();
                this.mSurface = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void fullScreenDestroy() {
        if (this.mFullScreen != null) {
            try {
                this.mFullScreen.release(false);
                this.mFullScreen = null;
                GlUtil.checkGlError("fullScreenDestroy done");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

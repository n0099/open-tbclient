package com.baidu.rtc.camera.filter.glfilter.a;

import android.content.Context;
import android.opengl.GLES30;
import android.text.TextUtils;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.util.LinkedList;
/* loaded from: classes5.dex */
public class a {
    protected String TAG;
    protected String aEZ;
    protected String aFa;
    protected boolean aSF;
    protected boolean aSG;
    protected int aSH;
    protected int aSI;
    protected int aSJ;
    protected int[] aSK;
    protected int[] aSL;
    protected int kX;
    protected Context mContext;
    protected int mCoordsPerVertex;
    protected int mFrameHeight;
    protected int mFrameWidth;
    protected int mImageHeight;
    protected int mImageWidth;
    protected int mPositionHandle;
    protected int mProgramHandle;
    private final LinkedList<Runnable> mRunOnDraw;
    protected int mVertexCount;

    public a(Context context) {
        this(context, "attribute vec4 aPosition;                                  \nattribute vec4 aTextureCoord;                              \nvarying vec2 textureCoordinate;                            \nvoid main() {                                              \n    gl_Position = aPosition;                               \n    textureCoordinate = aTextureCoord.xy;                  \n}                                                          \n", "precision mediump float;                                   \nvarying vec2 textureCoordinate;                            \nuniform sampler2D inputTexture;                                \nvoid main() {                                              \n    gl_FragColor = texture2D(inputTexture, textureCoordinate); \n}                                                          \n");
    }

    public a(Context context, String str, String str2) {
        this.TAG = getClass().getSimpleName();
        this.aSG = true;
        this.mCoordsPerVertex = 2;
        this.mVertexCount = com.baidu.rtc.camera.filter.glfilter.utils.b.aSP.length / this.mCoordsPerVertex;
        this.mFrameWidth = -1;
        this.mFrameHeight = -1;
        this.mContext = context;
        this.mRunOnDraw = new LinkedList<>();
        this.aEZ = str;
        this.aFa = str2;
        Di();
    }

    public void Di() {
        if (!TextUtils.isEmpty(this.aEZ) && !TextUtils.isEmpty(this.aFa)) {
            this.mProgramHandle = com.baidu.rtc.camera.filter.glfilter.utils.a.createProgram(this.aEZ, this.aFa);
            this.mPositionHandle = GLES30.glGetAttribLocation(this.mProgramHandle, "aPosition");
            this.kX = GLES30.glGetAttribLocation(this.mProgramHandle, "aTextureCoord");
            this.aSH = GLES30.glGetUniformLocation(this.mProgramHandle, "inputTexture");
            this.aSF = true;
            return;
        }
        this.mPositionHandle = -1;
        this.kX = -1;
        this.aSH = -1;
        this.aSF = false;
    }

    public void M(int i, int i2) {
        this.mImageWidth = i;
        this.mImageHeight = i2;
    }

    public void N(int i, int i2) {
        this.aSI = i;
        this.aSJ = i2;
    }

    public boolean c(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        if (this.aSF && i != -1 && this.aSG) {
            GLES30.glViewport(0, 0, this.aSI, this.aSJ);
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
            GLES30.glClear(16384);
            GLES30.glUseProgram(this.mProgramHandle);
            runPendingOnDrawTasks();
            e(i, floatBuffer, floatBuffer2);
            return true;
        }
        return false;
    }

    public int d(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        if (i != -1 && this.aSK != null && this.aSF && this.aSG) {
            GLES30.glViewport(0, 0, this.mFrameWidth, this.mFrameHeight);
            GLES30.glBindFramebuffer(36160, this.aSK[0]);
            GLES30.glUseProgram(this.mProgramHandle);
            runPendingOnDrawTasks();
            e(i, floatBuffer, floatBuffer2);
            GLES30.glBindFramebuffer(36160, 0);
            return this.aSL[0];
        }
        return i;
    }

    protected void e(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        floatBuffer.position(0);
        GLES30.glVertexAttribPointer(this.mPositionHandle, this.mCoordsPerVertex, 5126, false, 0, (Buffer) floatBuffer);
        GLES30.glEnableVertexAttribArray(this.mPositionHandle);
        floatBuffer2.position(0);
        GLES30.glVertexAttribPointer(this.kX, 2, 5126, false, 0, (Buffer) floatBuffer2);
        GLES30.glEnableVertexAttribArray(this.kX);
        GLES30.glActiveTexture(33984);
        GLES30.glBindTexture(Dm(), i);
        GLES30.glUniform1i(this.aSH, 0);
        Dj();
        Dk();
        Dl();
        GLES30.glDisableVertexAttribArray(this.mPositionHandle);
        GLES30.glDisableVertexAttribArray(this.kX);
        GLES30.glBindTexture(Dm(), 0);
        GLES30.glUseProgram(0);
    }

    public void Dj() {
    }

    protected void Dk() {
        GLES30.glDrawArrays(5, 0, this.mVertexCount);
    }

    public void Dl() {
    }

    public int Dm() {
        return 3553;
    }

    public void release() {
        if (this.aSF) {
            GLES30.glDeleteProgram(this.mProgramHandle);
            this.mProgramHandle = -1;
        }
        Dn();
    }

    public void O(int i, int i2) {
        if (isInitialized()) {
            if (this.aSK != null && (this.mFrameWidth != i || this.mFrameHeight != i2)) {
                Dn();
            }
            if (this.aSK == null) {
                this.mFrameWidth = i;
                this.mFrameHeight = i2;
                this.aSK = new int[1];
                this.aSL = new int[1];
                com.baidu.rtc.camera.filter.glfilter.utils.a.a(this.aSK, this.aSL, i, i2);
            }
        }
    }

    public void Dn() {
        if (this.aSF) {
            if (this.aSL != null) {
                GLES30.glDeleteTextures(1, this.aSL, 0);
                this.aSL = null;
            }
            if (this.aSK != null) {
                GLES30.glDeleteFramebuffers(1, this.aSK, 0);
                this.aSK = null;
            }
            this.mFrameWidth = -1;
            this.mFrameWidth = -1;
        }
    }

    public boolean isInitialized() {
        return this.aSF;
    }

    protected void runPendingOnDrawTasks() {
        while (!this.mRunOnDraw.isEmpty()) {
            this.mRunOnDraw.removeFirst().run();
        }
    }
}

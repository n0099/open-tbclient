package com.baidu.rtc.camera.filter.glfilter.a;

import android.content.Context;
import android.opengl.GLES30;
import android.text.TextUtils;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class a {
    protected String TAG;
    protected String aEh;
    protected String aEi;
    protected boolean aRN;
    protected boolean aRO;
    protected int aRP;
    protected int aRQ;
    protected int aRR;
    protected int[] aRS;
    protected int[] aRT;
    protected int lb;
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
        this.aRO = true;
        this.mCoordsPerVertex = 2;
        this.mVertexCount = com.baidu.rtc.camera.filter.glfilter.utils.b.aRX.length / this.mCoordsPerVertex;
        this.mFrameWidth = -1;
        this.mFrameHeight = -1;
        this.mContext = context;
        this.mRunOnDraw = new LinkedList<>();
        this.aEh = str;
        this.aEi = str2;
        CM();
    }

    public void CM() {
        if (!TextUtils.isEmpty(this.aEh) && !TextUtils.isEmpty(this.aEi)) {
            this.mProgramHandle = com.baidu.rtc.camera.filter.glfilter.utils.a.createProgram(this.aEh, this.aEi);
            this.mPositionHandle = GLES30.glGetAttribLocation(this.mProgramHandle, "aPosition");
            this.lb = GLES30.glGetAttribLocation(this.mProgramHandle, "aTextureCoord");
            this.aRP = GLES30.glGetUniformLocation(this.mProgramHandle, "inputTexture");
            this.aRN = true;
            return;
        }
        this.mPositionHandle = -1;
        this.lb = -1;
        this.aRP = -1;
        this.aRN = false;
    }

    public void I(int i, int i2) {
        this.mImageWidth = i;
        this.mImageHeight = i2;
    }

    public void J(int i, int i2) {
        this.aRQ = i;
        this.aRR = i2;
    }

    public boolean c(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        if (this.aRN && i != -1 && this.aRO) {
            GLES30.glViewport(0, 0, this.aRQ, this.aRR);
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
        if (i != -1 && this.aRS != null && this.aRN && this.aRO) {
            GLES30.glViewport(0, 0, this.mFrameWidth, this.mFrameHeight);
            GLES30.glBindFramebuffer(36160, this.aRS[0]);
            GLES30.glUseProgram(this.mProgramHandle);
            runPendingOnDrawTasks();
            e(i, floatBuffer, floatBuffer2);
            GLES30.glBindFramebuffer(36160, 0);
            return this.aRT[0];
        }
        return i;
    }

    protected void e(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        floatBuffer.position(0);
        GLES30.glVertexAttribPointer(this.mPositionHandle, this.mCoordsPerVertex, 5126, false, 0, (Buffer) floatBuffer);
        GLES30.glEnableVertexAttribArray(this.mPositionHandle);
        floatBuffer2.position(0);
        GLES30.glVertexAttribPointer(this.lb, 2, 5126, false, 0, (Buffer) floatBuffer2);
        GLES30.glEnableVertexAttribArray(this.lb);
        GLES30.glActiveTexture(33984);
        GLES30.glBindTexture(CQ(), i);
        GLES30.glUniform1i(this.aRP, 0);
        CN();
        CO();
        CP();
        GLES30.glDisableVertexAttribArray(this.mPositionHandle);
        GLES30.glDisableVertexAttribArray(this.lb);
        GLES30.glBindTexture(CQ(), 0);
        GLES30.glUseProgram(0);
    }

    public void CN() {
    }

    protected void CO() {
        GLES30.glDrawArrays(5, 0, this.mVertexCount);
    }

    public void CP() {
    }

    public int CQ() {
        return 3553;
    }

    public void release() {
        if (this.aRN) {
            GLES30.glDeleteProgram(this.mProgramHandle);
            this.mProgramHandle = -1;
        }
        CR();
    }

    public void K(int i, int i2) {
        if (isInitialized()) {
            if (this.aRS != null && (this.mFrameWidth != i || this.mFrameHeight != i2)) {
                CR();
            }
            if (this.aRS == null) {
                this.mFrameWidth = i;
                this.mFrameHeight = i2;
                this.aRS = new int[1];
                this.aRT = new int[1];
                com.baidu.rtc.camera.filter.glfilter.utils.a.a(this.aRS, this.aRT, i, i2);
            }
        }
    }

    public void CR() {
        if (this.aRN) {
            if (this.aRT != null) {
                GLES30.glDeleteTextures(1, this.aRT, 0);
                this.aRT = null;
            }
            if (this.aRS != null) {
                GLES30.glDeleteFramebuffers(1, this.aRS, 0);
                this.aRS = null;
            }
            this.mFrameWidth = -1;
            this.mFrameWidth = -1;
        }
    }

    public boolean isInitialized() {
        return this.aRN;
    }

    protected void runPendingOnDrawTasks() {
        while (!this.mRunOnDraw.isEmpty()) {
            this.mRunOnDraw.removeFirst().run();
        }
    }
}

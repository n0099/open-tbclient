package com.baidu.rtc.camera.filter.glfilter.a;

import android.content.Context;
import android.opengl.GLES30;
import android.text.TextUtils;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.util.LinkedList;
/* loaded from: classes6.dex */
public class a {
    protected String TAG;
    protected String aJh;
    protected String aJi;
    protected boolean aXg;
    protected boolean aXh;
    protected int aXi;
    protected int aXj;
    protected int aXk;
    protected int[] aXl;
    protected int[] aXm;
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
        this.aXh = true;
        this.mCoordsPerVertex = 2;
        this.mVertexCount = com.baidu.rtc.camera.filter.glfilter.utils.b.aXq.length / this.mCoordsPerVertex;
        this.mFrameWidth = -1;
        this.mFrameHeight = -1;
        this.mContext = context;
        this.mRunOnDraw = new LinkedList<>();
        this.aJh = str;
        this.aJi = str2;
        FG();
    }

    public void FG() {
        if (!TextUtils.isEmpty(this.aJh) && !TextUtils.isEmpty(this.aJi)) {
            this.mProgramHandle = com.baidu.rtc.camera.filter.glfilter.utils.a.createProgram(this.aJh, this.aJi);
            this.mPositionHandle = GLES30.glGetAttribLocation(this.mProgramHandle, "aPosition");
            this.lb = GLES30.glGetAttribLocation(this.mProgramHandle, "aTextureCoord");
            this.aXi = GLES30.glGetUniformLocation(this.mProgramHandle, "inputTexture");
            this.aXg = true;
            return;
        }
        this.mPositionHandle = -1;
        this.lb = -1;
        this.aXi = -1;
        this.aXg = false;
    }

    public void N(int i, int i2) {
        this.mImageWidth = i;
        this.mImageHeight = i2;
    }

    public void O(int i, int i2) {
        this.aXj = i;
        this.aXk = i2;
    }

    public boolean c(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        if (this.aXg && i != -1 && this.aXh) {
            GLES30.glViewport(0, 0, this.aXj, this.aXk);
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
        if (i != -1 && this.aXl != null && this.aXg && this.aXh) {
            GLES30.glViewport(0, 0, this.mFrameWidth, this.mFrameHeight);
            GLES30.glBindFramebuffer(36160, this.aXl[0]);
            GLES30.glUseProgram(this.mProgramHandle);
            runPendingOnDrawTasks();
            e(i, floatBuffer, floatBuffer2);
            GLES30.glBindFramebuffer(36160, 0);
            return this.aXm[0];
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
        GLES30.glBindTexture(FK(), i);
        GLES30.glUniform1i(this.aXi, 0);
        FH();
        FI();
        FJ();
        GLES30.glDisableVertexAttribArray(this.mPositionHandle);
        GLES30.glDisableVertexAttribArray(this.lb);
        GLES30.glBindTexture(FK(), 0);
        GLES30.glUseProgram(0);
    }

    public void FH() {
    }

    protected void FI() {
        GLES30.glDrawArrays(5, 0, this.mVertexCount);
    }

    public void FJ() {
    }

    public int FK() {
        return 3553;
    }

    public void release() {
        if (this.aXg) {
            GLES30.glDeleteProgram(this.mProgramHandle);
            this.mProgramHandle = -1;
        }
        FL();
    }

    public void P(int i, int i2) {
        if (isInitialized()) {
            if (this.aXl != null && (this.mFrameWidth != i || this.mFrameHeight != i2)) {
                FL();
            }
            if (this.aXl == null) {
                this.mFrameWidth = i;
                this.mFrameHeight = i2;
                this.aXl = new int[1];
                this.aXm = new int[1];
                com.baidu.rtc.camera.filter.glfilter.utils.a.a(this.aXl, this.aXm, i, i2);
            }
        }
    }

    public void FL() {
        if (this.aXg) {
            if (this.aXm != null) {
                GLES30.glDeleteTextures(1, this.aXm, 0);
                this.aXm = null;
            }
            if (this.aXl != null) {
                GLES30.glDeleteFramebuffers(1, this.aXl, 0);
                this.aXl = null;
            }
            this.mFrameWidth = -1;
            this.mFrameWidth = -1;
        }
    }

    public boolean isInitialized() {
        return this.aXg;
    }

    protected void runPendingOnDrawTasks() {
        while (!this.mRunOnDraw.isEmpty()) {
            this.mRunOnDraw.removeFirst().run();
        }
    }
}

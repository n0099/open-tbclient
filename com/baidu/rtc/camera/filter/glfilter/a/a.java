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
    protected String aJv;
    protected String aJw;
    protected boolean aXt;
    protected boolean aXu;
    protected int aXv;
    protected int aXw;
    protected int aXx;
    protected int[] aXy;
    protected int[] aXz;
    protected int kZ;
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
        this.aXu = true;
        this.mCoordsPerVertex = 2;
        this.mVertexCount = com.baidu.rtc.camera.filter.glfilter.utils.b.aXD.length / this.mCoordsPerVertex;
        this.mFrameWidth = -1;
        this.mFrameHeight = -1;
        this.mContext = context;
        this.mRunOnDraw = new LinkedList<>();
        this.aJv = str;
        this.aJw = str2;
        FL();
    }

    public void FL() {
        if (!TextUtils.isEmpty(this.aJv) && !TextUtils.isEmpty(this.aJw)) {
            this.mProgramHandle = com.baidu.rtc.camera.filter.glfilter.utils.a.createProgram(this.aJv, this.aJw);
            this.mPositionHandle = GLES30.glGetAttribLocation(this.mProgramHandle, "aPosition");
            this.kZ = GLES30.glGetAttribLocation(this.mProgramHandle, "aTextureCoord");
            this.aXv = GLES30.glGetUniformLocation(this.mProgramHandle, "inputTexture");
            this.aXt = true;
            return;
        }
        this.mPositionHandle = -1;
        this.kZ = -1;
        this.aXv = -1;
        this.aXt = false;
    }

    public void N(int i, int i2) {
        this.mImageWidth = i;
        this.mImageHeight = i2;
    }

    public void O(int i, int i2) {
        this.aXw = i;
        this.aXx = i2;
    }

    public boolean c(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        if (this.aXt && i != -1 && this.aXu) {
            GLES30.glViewport(0, 0, this.aXw, this.aXx);
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
        if (i != -1 && this.aXy != null && this.aXt && this.aXu) {
            GLES30.glViewport(0, 0, this.mFrameWidth, this.mFrameHeight);
            GLES30.glBindFramebuffer(36160, this.aXy[0]);
            GLES30.glUseProgram(this.mProgramHandle);
            runPendingOnDrawTasks();
            e(i, floatBuffer, floatBuffer2);
            GLES30.glBindFramebuffer(36160, 0);
            return this.aXz[0];
        }
        return i;
    }

    protected void e(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        floatBuffer.position(0);
        GLES30.glVertexAttribPointer(this.mPositionHandle, this.mCoordsPerVertex, 5126, false, 0, (Buffer) floatBuffer);
        GLES30.glEnableVertexAttribArray(this.mPositionHandle);
        floatBuffer2.position(0);
        GLES30.glVertexAttribPointer(this.kZ, 2, 5126, false, 0, (Buffer) floatBuffer2);
        GLES30.glEnableVertexAttribArray(this.kZ);
        GLES30.glActiveTexture(33984);
        GLES30.glBindTexture(FP(), i);
        GLES30.glUniform1i(this.aXv, 0);
        FM();
        FN();
        FO();
        GLES30.glDisableVertexAttribArray(this.mPositionHandle);
        GLES30.glDisableVertexAttribArray(this.kZ);
        GLES30.glBindTexture(FP(), 0);
        GLES30.glUseProgram(0);
    }

    public void FM() {
    }

    protected void FN() {
        GLES30.glDrawArrays(5, 0, this.mVertexCount);
    }

    public void FO() {
    }

    public int FP() {
        return 3553;
    }

    public void release() {
        if (this.aXt) {
            GLES30.glDeleteProgram(this.mProgramHandle);
            this.mProgramHandle = -1;
        }
        FQ();
    }

    public void P(int i, int i2) {
        if (isInitialized()) {
            if (this.aXy != null && (this.mFrameWidth != i || this.mFrameHeight != i2)) {
                FQ();
            }
            if (this.aXy == null) {
                this.mFrameWidth = i;
                this.mFrameHeight = i2;
                this.aXy = new int[1];
                this.aXz = new int[1];
                com.baidu.rtc.camera.filter.glfilter.utils.a.a(this.aXy, this.aXz, i, i2);
            }
        }
    }

    public void FQ() {
        if (this.aXt) {
            if (this.aXz != null) {
                GLES30.glDeleteTextures(1, this.aXz, 0);
                this.aXz = null;
            }
            if (this.aXy != null) {
                GLES30.glDeleteFramebuffers(1, this.aXy, 0);
                this.aXy = null;
            }
            this.mFrameWidth = -1;
            this.mFrameWidth = -1;
        }
    }

    public boolean isInitialized() {
        return this.aXt;
    }

    protected void runPendingOnDrawTasks() {
        while (!this.mRunOnDraw.isEmpty()) {
            this.mRunOnDraw.removeFirst().run();
        }
    }
}

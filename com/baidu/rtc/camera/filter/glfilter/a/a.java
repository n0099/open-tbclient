package com.baidu.rtc.camera.filter.glfilter.a;

import android.content.Context;
import android.opengl.GLES30;
import android.text.TextUtils;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.util.LinkedList;
/* loaded from: classes11.dex */
public class a {
    protected String TAG;
    protected boolean bOp;
    protected int bOq;
    protected int bOr;
    protected int bOs;
    protected int bOt;
    protected int bOu;
    protected int[] bOv;
    protected int[] bOw;
    protected Context mContext;
    protected int mCoordsPerVertex;
    protected int mDisplayHeight;
    protected int mDisplayWidth;
    protected String mFragmentShader;
    protected int mImageHeight;
    protected int mImageWidth;
    protected boolean mIsInitialized;
    protected int mProgramHandle;
    private final LinkedList<Runnable> mRunOnDraw;
    protected int mVertexCount;
    protected String mVertexShader;

    public a(Context context) {
        this(context, "attribute vec4 aPosition;                                  \nattribute vec4 aTextureCoord;                              \nvarying vec2 textureCoordinate;                            \nvoid main() {                                              \n    gl_Position = aPosition;                               \n    textureCoordinate = aTextureCoord.xy;                  \n}                                                          \n", "precision mediump float;                                   \nvarying vec2 textureCoordinate;                            \nuniform sampler2D inputTexture;                                \nvoid main() {                                              \n    gl_FragColor = texture2D(inputTexture, textureCoordinate); \n}                                                          \n");
    }

    public a(Context context, String str, String str2) {
        this.TAG = getClass().getSimpleName();
        this.bOp = true;
        this.mCoordsPerVertex = 2;
        this.mVertexCount = com.baidu.rtc.camera.filter.glfilter.utils.b.bOA.length / this.mCoordsPerVertex;
        this.bOt = -1;
        this.bOu = -1;
        this.mContext = context;
        this.mRunOnDraw = new LinkedList<>();
        this.mVertexShader = str;
        this.mFragmentShader = str2;
        Xa();
    }

    public void Xa() {
        if (!TextUtils.isEmpty(this.mVertexShader) && !TextUtils.isEmpty(this.mFragmentShader)) {
            this.mProgramHandle = com.baidu.rtc.camera.filter.glfilter.utils.a.createProgram(this.mVertexShader, this.mFragmentShader);
            this.bOq = GLES30.glGetAttribLocation(this.mProgramHandle, "aPosition");
            this.bOr = GLES30.glGetAttribLocation(this.mProgramHandle, "aTextureCoord");
            this.bOs = GLES30.glGetUniformLocation(this.mProgramHandle, "inputTexture");
            this.mIsInitialized = true;
            return;
        }
        this.bOq = -1;
        this.bOr = -1;
        this.bOs = -1;
        this.mIsInitialized = false;
    }

    public void onInputSizeChanged(int i, int i2) {
        this.mImageWidth = i;
        this.mImageHeight = i2;
    }

    public void X(int i, int i2) {
        this.mDisplayWidth = i;
        this.mDisplayHeight = i2;
    }

    public boolean a(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        if (this.mIsInitialized && i != -1 && this.bOp) {
            GLES30.glViewport(0, 0, this.mDisplayWidth, this.mDisplayHeight);
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
            GLES30.glClear(16384);
            GLES30.glUseProgram(this.mProgramHandle);
            runPendingOnDrawTasks();
            c(i, floatBuffer, floatBuffer2);
            return true;
        }
        return false;
    }

    public int b(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        if (i != -1 && this.bOv != null && this.mIsInitialized && this.bOp) {
            GLES30.glViewport(0, 0, this.bOt, this.bOu);
            GLES30.glBindFramebuffer(36160, this.bOv[0]);
            GLES30.glUseProgram(this.mProgramHandle);
            runPendingOnDrawTasks();
            c(i, floatBuffer, floatBuffer2);
            GLES30.glBindFramebuffer(36160, 0);
            return this.bOw[0];
        }
        return i;
    }

    protected void c(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        floatBuffer.position(0);
        GLES30.glVertexAttribPointer(this.bOq, this.mCoordsPerVertex, 5126, false, 0, (Buffer) floatBuffer);
        GLES30.glEnableVertexAttribArray(this.bOq);
        floatBuffer2.position(0);
        GLES30.glVertexAttribPointer(this.bOr, 2, 5126, false, 0, (Buffer) floatBuffer2);
        GLES30.glEnableVertexAttribArray(this.bOr);
        GLES30.glActiveTexture(33984);
        GLES30.glBindTexture(Xe(), i);
        GLES30.glUniform1i(this.bOs, 0);
        Xb();
        Xc();
        Xd();
        GLES30.glDisableVertexAttribArray(this.bOq);
        GLES30.glDisableVertexAttribArray(this.bOr);
        GLES30.glBindTexture(Xe(), 0);
        GLES30.glUseProgram(0);
    }

    public void Xb() {
    }

    protected void Xc() {
        GLES30.glDrawArrays(5, 0, this.mVertexCount);
    }

    public void Xd() {
    }

    public int Xe() {
        return 3553;
    }

    public void release() {
        if (this.mIsInitialized) {
            GLES30.glDeleteProgram(this.mProgramHandle);
            this.mProgramHandle = -1;
        }
        destroyFrameBuffer();
    }

    public void Y(int i, int i2) {
        if (isInitialized()) {
            if (this.bOv != null && (this.bOt != i || this.bOu != i2)) {
                destroyFrameBuffer();
            }
            if (this.bOv == null) {
                this.bOt = i;
                this.bOu = i2;
                this.bOv = new int[1];
                this.bOw = new int[1];
                com.baidu.rtc.camera.filter.glfilter.utils.a.a(this.bOv, this.bOw, i, i2);
            }
        }
    }

    public void destroyFrameBuffer() {
        if (this.mIsInitialized) {
            if (this.bOw != null) {
                GLES30.glDeleteTextures(1, this.bOw, 0);
                this.bOw = null;
            }
            if (this.bOv != null) {
                GLES30.glDeleteFramebuffers(1, this.bOv, 0);
                this.bOv = null;
            }
            this.bOt = -1;
            this.bOt = -1;
        }
    }

    public boolean isInitialized() {
        return this.mIsInitialized;
    }

    protected void runPendingOnDrawTasks() {
        while (!this.mRunOnDraw.isEmpty()) {
            this.mRunOnDraw.removeFirst().run();
        }
    }
}

package com.baidu.rtc.camera.filter.glfilter.a;

import android.content.Context;
import android.opengl.GLES30;
import android.text.TextUtils;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.util.LinkedList;
/* loaded from: classes15.dex */
public class a {
    protected String TAG;
    protected boolean bQp;
    protected int bQq;
    protected int bQr;
    protected int bQs;
    protected int bQt;
    protected int bQu;
    protected int[] bQv;
    protected int[] bQw;
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
        this.bQp = true;
        this.mCoordsPerVertex = 2;
        this.mVertexCount = com.baidu.rtc.camera.filter.glfilter.utils.b.bQA.length / this.mCoordsPerVertex;
        this.bQt = -1;
        this.bQu = -1;
        this.mContext = context;
        this.mRunOnDraw = new LinkedList<>();
        this.mVertexShader = str;
        this.mFragmentShader = str2;
        XJ();
    }

    public void XJ() {
        if (!TextUtils.isEmpty(this.mVertexShader) && !TextUtils.isEmpty(this.mFragmentShader)) {
            this.mProgramHandle = com.baidu.rtc.camera.filter.glfilter.utils.a.createProgram(this.mVertexShader, this.mFragmentShader);
            this.bQq = GLES30.glGetAttribLocation(this.mProgramHandle, "aPosition");
            this.bQr = GLES30.glGetAttribLocation(this.mProgramHandle, "aTextureCoord");
            this.bQs = GLES30.glGetUniformLocation(this.mProgramHandle, "inputTexture");
            this.mIsInitialized = true;
            return;
        }
        this.bQq = -1;
        this.bQr = -1;
        this.bQs = -1;
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
        if (this.mIsInitialized && i != -1 && this.bQp) {
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
        if (i != -1 && this.bQv != null && this.mIsInitialized && this.bQp) {
            GLES30.glViewport(0, 0, this.bQt, this.bQu);
            GLES30.glBindFramebuffer(36160, this.bQv[0]);
            GLES30.glUseProgram(this.mProgramHandle);
            runPendingOnDrawTasks();
            c(i, floatBuffer, floatBuffer2);
            GLES30.glBindFramebuffer(36160, 0);
            return this.bQw[0];
        }
        return i;
    }

    protected void c(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        floatBuffer.position(0);
        GLES30.glVertexAttribPointer(this.bQq, this.mCoordsPerVertex, 5126, false, 0, (Buffer) floatBuffer);
        GLES30.glEnableVertexAttribArray(this.bQq);
        floatBuffer2.position(0);
        GLES30.glVertexAttribPointer(this.bQr, 2, 5126, false, 0, (Buffer) floatBuffer2);
        GLES30.glEnableVertexAttribArray(this.bQr);
        GLES30.glActiveTexture(33984);
        GLES30.glBindTexture(XN(), i);
        GLES30.glUniform1i(this.bQs, 0);
        XK();
        XL();
        XM();
        GLES30.glDisableVertexAttribArray(this.bQq);
        GLES30.glDisableVertexAttribArray(this.bQr);
        GLES30.glBindTexture(XN(), 0);
        GLES30.glUseProgram(0);
    }

    public void XK() {
    }

    protected void XL() {
        GLES30.glDrawArrays(5, 0, this.mVertexCount);
    }

    public void XM() {
    }

    public int XN() {
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
            if (this.bQv != null && (this.bQt != i || this.bQu != i2)) {
                destroyFrameBuffer();
            }
            if (this.bQv == null) {
                this.bQt = i;
                this.bQu = i2;
                this.bQv = new int[1];
                this.bQw = new int[1];
                com.baidu.rtc.camera.filter.glfilter.utils.a.a(this.bQv, this.bQw, i, i2);
            }
        }
    }

    public void destroyFrameBuffer() {
        if (this.mIsInitialized) {
            if (this.bQw != null) {
                GLES30.glDeleteTextures(1, this.bQw, 0);
                this.bQw = null;
            }
            if (this.bQv != null) {
                GLES30.glDeleteFramebuffers(1, this.bQv, 0);
                this.bQv = null;
            }
            this.bQt = -1;
            this.bQt = -1;
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

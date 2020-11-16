package com.baidu.rtc.camera.filter.glfilter.a;

import android.content.Context;
import android.opengl.GLES30;
import android.text.TextUtils;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.util.LinkedList;
/* loaded from: classes16.dex */
public class a {
    protected String TAG;
    protected int[] cmA;
    protected int[] cmB;
    protected boolean cmu;
    protected int cmv;
    protected int cmw;
    protected int cmx;
    protected int cmy;
    protected int cmz;
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
        this.cmu = true;
        this.mCoordsPerVertex = 2;
        this.mVertexCount = com.baidu.rtc.camera.filter.glfilter.utils.b.cmF.length / this.mCoordsPerVertex;
        this.cmy = -1;
        this.cmz = -1;
        this.mContext = context;
        this.mRunOnDraw = new LinkedList<>();
        this.mVertexShader = str;
        this.mFragmentShader = str2;
        adM();
    }

    public void adM() {
        if (!TextUtils.isEmpty(this.mVertexShader) && !TextUtils.isEmpty(this.mFragmentShader)) {
            this.mProgramHandle = com.baidu.rtc.camera.filter.glfilter.utils.a.createProgram(this.mVertexShader, this.mFragmentShader);
            this.cmv = GLES30.glGetAttribLocation(this.mProgramHandle, "aPosition");
            this.cmw = GLES30.glGetAttribLocation(this.mProgramHandle, "aTextureCoord");
            this.cmx = GLES30.glGetUniformLocation(this.mProgramHandle, "inputTexture");
            this.mIsInitialized = true;
            return;
        }
        this.cmv = -1;
        this.cmw = -1;
        this.cmx = -1;
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
        if (this.mIsInitialized && i != -1 && this.cmu) {
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
        if (i != -1 && this.cmA != null && this.mIsInitialized && this.cmu) {
            GLES30.glViewport(0, 0, this.cmy, this.cmz);
            GLES30.glBindFramebuffer(36160, this.cmA[0]);
            GLES30.glUseProgram(this.mProgramHandle);
            runPendingOnDrawTasks();
            c(i, floatBuffer, floatBuffer2);
            GLES30.glBindFramebuffer(36160, 0);
            return this.cmB[0];
        }
        return i;
    }

    protected void c(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        floatBuffer.position(0);
        GLES30.glVertexAttribPointer(this.cmv, this.mCoordsPerVertex, 5126, false, 0, (Buffer) floatBuffer);
        GLES30.glEnableVertexAttribArray(this.cmv);
        floatBuffer2.position(0);
        GLES30.glVertexAttribPointer(this.cmw, 2, 5126, false, 0, (Buffer) floatBuffer2);
        GLES30.glEnableVertexAttribArray(this.cmw);
        GLES30.glActiveTexture(33984);
        GLES30.glBindTexture(adQ(), i);
        GLES30.glUniform1i(this.cmx, 0);
        adN();
        adO();
        adP();
        GLES30.glDisableVertexAttribArray(this.cmv);
        GLES30.glDisableVertexAttribArray(this.cmw);
        GLES30.glBindTexture(adQ(), 0);
        GLES30.glUseProgram(0);
    }

    public void adN() {
    }

    protected void adO() {
        GLES30.glDrawArrays(5, 0, this.mVertexCount);
    }

    public void adP() {
    }

    public int adQ() {
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
            if (this.cmA != null && (this.cmy != i || this.cmz != i2)) {
                destroyFrameBuffer();
            }
            if (this.cmA == null) {
                this.cmy = i;
                this.cmz = i2;
                this.cmA = new int[1];
                this.cmB = new int[1];
                com.baidu.rtc.camera.filter.glfilter.utils.a.a(this.cmA, this.cmB, i, i2);
            }
        }
    }

    public void destroyFrameBuffer() {
        if (this.mIsInitialized) {
            if (this.cmB != null) {
                GLES30.glDeleteTextures(1, this.cmB, 0);
                this.cmB = null;
            }
            if (this.cmA != null) {
                GLES30.glDeleteFramebuffers(1, this.cmA, 0);
                this.cmA = null;
            }
            this.cmy = -1;
            this.cmy = -1;
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

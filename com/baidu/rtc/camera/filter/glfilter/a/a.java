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
    protected boolean bZL;
    protected int bZM;
    protected int bZN;
    protected int bZO;
    protected int bZP;
    protected int bZQ;
    protected int[] bZR;
    protected int[] bZS;
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
        this.bZL = true;
        this.mCoordsPerVertex = 2;
        this.mVertexCount = com.baidu.rtc.camera.filter.glfilter.utils.b.bZW.length / this.mCoordsPerVertex;
        this.bZP = -1;
        this.bZQ = -1;
        this.mContext = context;
        this.mRunOnDraw = new LinkedList<>();
        this.mVertexShader = str;
        this.mFragmentShader = str2;
        aaa();
    }

    public void aaa() {
        if (!TextUtils.isEmpty(this.mVertexShader) && !TextUtils.isEmpty(this.mFragmentShader)) {
            this.mProgramHandle = com.baidu.rtc.camera.filter.glfilter.utils.a.createProgram(this.mVertexShader, this.mFragmentShader);
            this.bZM = GLES30.glGetAttribLocation(this.mProgramHandle, "aPosition");
            this.bZN = GLES30.glGetAttribLocation(this.mProgramHandle, "aTextureCoord");
            this.bZO = GLES30.glGetUniformLocation(this.mProgramHandle, "inputTexture");
            this.mIsInitialized = true;
            return;
        }
        this.bZM = -1;
        this.bZN = -1;
        this.bZO = -1;
        this.mIsInitialized = false;
    }

    public void onInputSizeChanged(int i, int i2) {
        this.mImageWidth = i;
        this.mImageHeight = i2;
    }

    public void W(int i, int i2) {
        this.mDisplayWidth = i;
        this.mDisplayHeight = i2;
    }

    public boolean a(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        if (this.mIsInitialized && i != -1 && this.bZL) {
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
        if (i != -1 && this.bZR != null && this.mIsInitialized && this.bZL) {
            GLES30.glViewport(0, 0, this.bZP, this.bZQ);
            GLES30.glBindFramebuffer(36160, this.bZR[0]);
            GLES30.glUseProgram(this.mProgramHandle);
            runPendingOnDrawTasks();
            c(i, floatBuffer, floatBuffer2);
            GLES30.glBindFramebuffer(36160, 0);
            return this.bZS[0];
        }
        return i;
    }

    protected void c(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        floatBuffer.position(0);
        GLES30.glVertexAttribPointer(this.bZM, this.mCoordsPerVertex, 5126, false, 0, (Buffer) floatBuffer);
        GLES30.glEnableVertexAttribArray(this.bZM);
        floatBuffer2.position(0);
        GLES30.glVertexAttribPointer(this.bZN, 2, 5126, false, 0, (Buffer) floatBuffer2);
        GLES30.glEnableVertexAttribArray(this.bZN);
        GLES30.glActiveTexture(33984);
        GLES30.glBindTexture(aae(), i);
        GLES30.glUniform1i(this.bZO, 0);
        aab();
        aac();
        aad();
        GLES30.glDisableVertexAttribArray(this.bZM);
        GLES30.glDisableVertexAttribArray(this.bZN);
        GLES30.glBindTexture(aae(), 0);
        GLES30.glUseProgram(0);
    }

    public void aab() {
    }

    protected void aac() {
        GLES30.glDrawArrays(5, 0, this.mVertexCount);
    }

    public void aad() {
    }

    public int aae() {
        return 3553;
    }

    public void release() {
        if (this.mIsInitialized) {
            GLES30.glDeleteProgram(this.mProgramHandle);
            this.mProgramHandle = -1;
        }
        destroyFrameBuffer();
    }

    public void X(int i, int i2) {
        if (isInitialized()) {
            if (this.bZR != null && (this.bZP != i || this.bZQ != i2)) {
                destroyFrameBuffer();
            }
            if (this.bZR == null) {
                this.bZP = i;
                this.bZQ = i2;
                this.bZR = new int[1];
                this.bZS = new int[1];
                com.baidu.rtc.camera.filter.glfilter.utils.a.a(this.bZR, this.bZS, i, i2);
            }
        }
    }

    public void destroyFrameBuffer() {
        if (this.mIsInitialized) {
            if (this.bZS != null) {
                GLES30.glDeleteTextures(1, this.bZS, 0);
                this.bZS = null;
            }
            if (this.bZR != null) {
                GLES30.glDeleteFramebuffers(1, this.bZR, 0);
                this.bZR = null;
            }
            this.bZP = -1;
            this.bZP = -1;
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

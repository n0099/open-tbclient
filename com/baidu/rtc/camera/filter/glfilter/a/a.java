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
    protected boolean cik;
    protected int cil;
    protected int cim;
    protected int cin;
    protected int cio;
    protected int cip;
    protected int[] ciq;
    protected int[] cir;
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
        this.cik = true;
        this.mCoordsPerVertex = 2;
        this.mVertexCount = com.baidu.rtc.camera.filter.glfilter.utils.b.civ.length / this.mCoordsPerVertex;
        this.cio = -1;
        this.cip = -1;
        this.mContext = context;
        this.mRunOnDraw = new LinkedList<>();
        this.mVertexShader = str;
        this.mFragmentShader = str2;
        abU();
    }

    public void abU() {
        if (!TextUtils.isEmpty(this.mVertexShader) && !TextUtils.isEmpty(this.mFragmentShader)) {
            this.mProgramHandle = com.baidu.rtc.camera.filter.glfilter.utils.a.createProgram(this.mVertexShader, this.mFragmentShader);
            this.cil = GLES30.glGetAttribLocation(this.mProgramHandle, "aPosition");
            this.cim = GLES30.glGetAttribLocation(this.mProgramHandle, "aTextureCoord");
            this.cin = GLES30.glGetUniformLocation(this.mProgramHandle, "inputTexture");
            this.mIsInitialized = true;
            return;
        }
        this.cil = -1;
        this.cim = -1;
        this.cin = -1;
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
        if (this.mIsInitialized && i != -1 && this.cik) {
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
        if (i != -1 && this.ciq != null && this.mIsInitialized && this.cik) {
            GLES30.glViewport(0, 0, this.cio, this.cip);
            GLES30.glBindFramebuffer(36160, this.ciq[0]);
            GLES30.glUseProgram(this.mProgramHandle);
            runPendingOnDrawTasks();
            c(i, floatBuffer, floatBuffer2);
            GLES30.glBindFramebuffer(36160, 0);
            return this.cir[0];
        }
        return i;
    }

    protected void c(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        floatBuffer.position(0);
        GLES30.glVertexAttribPointer(this.cil, this.mCoordsPerVertex, 5126, false, 0, (Buffer) floatBuffer);
        GLES30.glEnableVertexAttribArray(this.cil);
        floatBuffer2.position(0);
        GLES30.glVertexAttribPointer(this.cim, 2, 5126, false, 0, (Buffer) floatBuffer2);
        GLES30.glEnableVertexAttribArray(this.cim);
        GLES30.glActiveTexture(33984);
        GLES30.glBindTexture(abY(), i);
        GLES30.glUniform1i(this.cin, 0);
        abV();
        abW();
        abX();
        GLES30.glDisableVertexAttribArray(this.cil);
        GLES30.glDisableVertexAttribArray(this.cim);
        GLES30.glBindTexture(abY(), 0);
        GLES30.glUseProgram(0);
    }

    public void abV() {
    }

    protected void abW() {
        GLES30.glDrawArrays(5, 0, this.mVertexCount);
    }

    public void abX() {
    }

    public int abY() {
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
            if (this.ciq != null && (this.cio != i || this.cip != i2)) {
                destroyFrameBuffer();
            }
            if (this.ciq == null) {
                this.cio = i;
                this.cip = i2;
                this.ciq = new int[1];
                this.cir = new int[1];
                com.baidu.rtc.camera.filter.glfilter.utils.a.a(this.ciq, this.cir, i, i2);
            }
        }
    }

    public void destroyFrameBuffer() {
        if (this.mIsInitialized) {
            if (this.cir != null) {
                GLES30.glDeleteTextures(1, this.cir, 0);
                this.cir = null;
            }
            if (this.ciq != null) {
                GLES30.glDeleteFramebuffers(1, this.ciq, 0);
                this.ciq = null;
            }
            this.cio = -1;
            this.cio = -1;
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

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
    protected boolean ctp;
    protected int ctq;
    protected int cts;
    protected int ctt;
    protected int ctu;
    protected int ctv;
    protected int[] ctw;
    protected int[] ctx;
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
        this.ctp = true;
        this.mCoordsPerVertex = 2;
        this.mVertexCount = com.baidu.rtc.camera.filter.glfilter.utils.b.ctB.length / this.mCoordsPerVertex;
        this.ctu = -1;
        this.ctv = -1;
        this.mContext = context;
        this.mRunOnDraw = new LinkedList<>();
        this.mVertexShader = str;
        this.mFragmentShader = str2;
        agU();
    }

    public void agU() {
        if (!TextUtils.isEmpty(this.mVertexShader) && !TextUtils.isEmpty(this.mFragmentShader)) {
            this.mProgramHandle = com.baidu.rtc.camera.filter.glfilter.utils.a.createProgram(this.mVertexShader, this.mFragmentShader);
            this.ctq = GLES30.glGetAttribLocation(this.mProgramHandle, "aPosition");
            this.cts = GLES30.glGetAttribLocation(this.mProgramHandle, "aTextureCoord");
            this.ctt = GLES30.glGetUniformLocation(this.mProgramHandle, "inputTexture");
            this.mIsInitialized = true;
            return;
        }
        this.ctq = -1;
        this.cts = -1;
        this.ctt = -1;
        this.mIsInitialized = false;
    }

    public void onInputSizeChanged(int i, int i2) {
        this.mImageWidth = i;
        this.mImageHeight = i2;
    }

    public void Z(int i, int i2) {
        this.mDisplayWidth = i;
        this.mDisplayHeight = i2;
    }

    public boolean a(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        if (this.mIsInitialized && i != -1 && this.ctp) {
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
        if (i != -1 && this.ctw != null && this.mIsInitialized && this.ctp) {
            GLES30.glViewport(0, 0, this.ctu, this.ctv);
            GLES30.glBindFramebuffer(36160, this.ctw[0]);
            GLES30.glUseProgram(this.mProgramHandle);
            runPendingOnDrawTasks();
            c(i, floatBuffer, floatBuffer2);
            GLES30.glBindFramebuffer(36160, 0);
            return this.ctx[0];
        }
        return i;
    }

    protected void c(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        floatBuffer.position(0);
        GLES30.glVertexAttribPointer(this.ctq, this.mCoordsPerVertex, 5126, false, 0, (Buffer) floatBuffer);
        GLES30.glEnableVertexAttribArray(this.ctq);
        floatBuffer2.position(0);
        GLES30.glVertexAttribPointer(this.cts, 2, 5126, false, 0, (Buffer) floatBuffer2);
        GLES30.glEnableVertexAttribArray(this.cts);
        GLES30.glActiveTexture(33984);
        GLES30.glBindTexture(agY(), i);
        GLES30.glUniform1i(this.ctt, 0);
        agV();
        agW();
        agX();
        GLES30.glDisableVertexAttribArray(this.ctq);
        GLES30.glDisableVertexAttribArray(this.cts);
        GLES30.glBindTexture(agY(), 0);
        GLES30.glUseProgram(0);
    }

    public void agV() {
    }

    protected void agW() {
        GLES30.glDrawArrays(5, 0, this.mVertexCount);
    }

    public void agX() {
    }

    public int agY() {
        return 3553;
    }

    public void release() {
        if (this.mIsInitialized) {
            GLES30.glDeleteProgram(this.mProgramHandle);
            this.mProgramHandle = -1;
        }
        destroyFrameBuffer();
    }

    public void aa(int i, int i2) {
        if (isInitialized()) {
            if (this.ctw != null && (this.ctu != i || this.ctv != i2)) {
                destroyFrameBuffer();
            }
            if (this.ctw == null) {
                this.ctu = i;
                this.ctv = i2;
                this.ctw = new int[1];
                this.ctx = new int[1];
                com.baidu.rtc.camera.filter.glfilter.utils.a.a(this.ctw, this.ctx, i, i2);
            }
        }
    }

    public void destroyFrameBuffer() {
        if (this.mIsInitialized) {
            if (this.ctx != null) {
                GLES30.glDeleteTextures(1, this.ctx, 0);
                this.ctx = null;
            }
            if (this.ctw != null) {
                GLES30.glDeleteFramebuffers(1, this.ctw, 0);
                this.ctw = null;
            }
            this.ctu = -1;
            this.ctu = -1;
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

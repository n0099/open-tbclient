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
    protected boolean cof;
    protected int cog;
    protected int coh;
    protected int coi;
    protected int coj;
    protected int cok;
    protected int[] col;

    /* renamed from: com  reason: collision with root package name */
    protected int[] f3197com;
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
        this.cof = true;
        this.mCoordsPerVertex = 2;
        this.mVertexCount = com.baidu.rtc.camera.filter.glfilter.utils.b.cor.length / this.mCoordsPerVertex;
        this.coj = -1;
        this.cok = -1;
        this.mContext = context;
        this.mRunOnDraw = new LinkedList<>();
        this.mVertexShader = str;
        this.mFragmentShader = str2;
        aeu();
    }

    public void aeu() {
        if (!TextUtils.isEmpty(this.mVertexShader) && !TextUtils.isEmpty(this.mFragmentShader)) {
            this.mProgramHandle = com.baidu.rtc.camera.filter.glfilter.utils.a.createProgram(this.mVertexShader, this.mFragmentShader);
            this.cog = GLES30.glGetAttribLocation(this.mProgramHandle, "aPosition");
            this.coh = GLES30.glGetAttribLocation(this.mProgramHandle, "aTextureCoord");
            this.coi = GLES30.glGetUniformLocation(this.mProgramHandle, "inputTexture");
            this.mIsInitialized = true;
            return;
        }
        this.cog = -1;
        this.coh = -1;
        this.coi = -1;
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
        if (this.mIsInitialized && i != -1 && this.cof) {
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
        if (i != -1 && this.col != null && this.mIsInitialized && this.cof) {
            GLES30.glViewport(0, 0, this.coj, this.cok);
            GLES30.glBindFramebuffer(36160, this.col[0]);
            GLES30.glUseProgram(this.mProgramHandle);
            runPendingOnDrawTasks();
            c(i, floatBuffer, floatBuffer2);
            GLES30.glBindFramebuffer(36160, 0);
            return this.f3197com[0];
        }
        return i;
    }

    protected void c(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        floatBuffer.position(0);
        GLES30.glVertexAttribPointer(this.cog, this.mCoordsPerVertex, 5126, false, 0, (Buffer) floatBuffer);
        GLES30.glEnableVertexAttribArray(this.cog);
        floatBuffer2.position(0);
        GLES30.glVertexAttribPointer(this.coh, 2, 5126, false, 0, (Buffer) floatBuffer2);
        GLES30.glEnableVertexAttribArray(this.coh);
        GLES30.glActiveTexture(33984);
        GLES30.glBindTexture(aey(), i);
        GLES30.glUniform1i(this.coi, 0);
        aev();
        aew();
        aex();
        GLES30.glDisableVertexAttribArray(this.cog);
        GLES30.glDisableVertexAttribArray(this.coh);
        GLES30.glBindTexture(aey(), 0);
        GLES30.glUseProgram(0);
    }

    public void aev() {
    }

    protected void aew() {
        GLES30.glDrawArrays(5, 0, this.mVertexCount);
    }

    public void aex() {
    }

    public int aey() {
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
            if (this.col != null && (this.coj != i || this.cok != i2)) {
                destroyFrameBuffer();
            }
            if (this.col == null) {
                this.coj = i;
                this.cok = i2;
                this.col = new int[1];
                this.f3197com = new int[1];
                com.baidu.rtc.camera.filter.glfilter.utils.a.a(this.col, this.f3197com, i, i2);
            }
        }
    }

    public void destroyFrameBuffer() {
        if (this.mIsInitialized) {
            if (this.f3197com != null) {
                GLES30.glDeleteTextures(1, this.f3197com, 0);
                this.f3197com = null;
            }
            if (this.col != null) {
                GLES30.glDeleteFramebuffers(1, this.col, 0);
                this.col = null;
            }
            this.coj = -1;
            this.coj = -1;
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

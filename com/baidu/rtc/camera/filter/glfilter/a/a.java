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
    protected String bfn;
    protected String bfo;
    protected boolean bvP;
    protected boolean bvQ;
    protected int bvR;
    protected int bvS;
    protected int bvT;
    protected int bvU;
    protected int bvV;
    protected int bvW;
    protected int bvX;
    protected int[] bvY;
    protected int[] bvZ;
    protected Context mContext;
    protected int mCoordsPerVertex;
    protected int mImageHeight;
    protected int mImageWidth;
    protected int mProgramHandle;
    private final LinkedList<Runnable> mRunOnDraw;
    protected int mVertexCount;

    public a(Context context) {
        this(context, "attribute vec4 aPosition;                                  \nattribute vec4 aTextureCoord;                              \nvarying vec2 textureCoordinate;                            \nvoid main() {                                              \n    gl_Position = aPosition;                               \n    textureCoordinate = aTextureCoord.xy;                  \n}                                                          \n", "precision mediump float;                                   \nvarying vec2 textureCoordinate;                            \nuniform sampler2D inputTexture;                                \nvoid main() {                                              \n    gl_FragColor = texture2D(inputTexture, textureCoordinate); \n}                                                          \n");
    }

    public a(Context context, String str, String str2) {
        this.TAG = getClass().getSimpleName();
        this.bvQ = true;
        this.mCoordsPerVertex = 2;
        this.mVertexCount = com.baidu.rtc.camera.filter.glfilter.utils.b.bwd.length / this.mCoordsPerVertex;
        this.bvW = -1;
        this.bvX = -1;
        this.mContext = context;
        this.mRunOnDraw = new LinkedList<>();
        this.bfn = str;
        this.bfo = str2;
        Nx();
    }

    public void Nx() {
        if (!TextUtils.isEmpty(this.bfn) && !TextUtils.isEmpty(this.bfo)) {
            this.mProgramHandle = com.baidu.rtc.camera.filter.glfilter.utils.a.createProgram(this.bfn, this.bfo);
            this.bvR = GLES30.glGetAttribLocation(this.mProgramHandle, "aPosition");
            this.bvS = GLES30.glGetAttribLocation(this.mProgramHandle, "aTextureCoord");
            this.bvT = GLES30.glGetUniformLocation(this.mProgramHandle, "inputTexture");
            this.bvP = true;
            return;
        }
        this.bvR = -1;
        this.bvS = -1;
        this.bvT = -1;
        this.bvP = false;
    }

    public void P(int i, int i2) {
        this.mImageWidth = i;
        this.mImageHeight = i2;
    }

    public void Q(int i, int i2) {
        this.bvU = i;
        this.bvV = i2;
    }

    public boolean a(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        if (this.bvP && i != -1 && this.bvQ) {
            GLES30.glViewport(0, 0, this.bvU, this.bvV);
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
        if (i != -1 && this.bvY != null && this.bvP && this.bvQ) {
            GLES30.glViewport(0, 0, this.bvW, this.bvX);
            GLES30.glBindFramebuffer(36160, this.bvY[0]);
            GLES30.glUseProgram(this.mProgramHandle);
            runPendingOnDrawTasks();
            c(i, floatBuffer, floatBuffer2);
            GLES30.glBindFramebuffer(36160, 0);
            return this.bvZ[0];
        }
        return i;
    }

    protected void c(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        floatBuffer.position(0);
        GLES30.glVertexAttribPointer(this.bvR, this.mCoordsPerVertex, 5126, false, 0, (Buffer) floatBuffer);
        GLES30.glEnableVertexAttribArray(this.bvR);
        floatBuffer2.position(0);
        GLES30.glVertexAttribPointer(this.bvS, 2, 5126, false, 0, (Buffer) floatBuffer2);
        GLES30.glEnableVertexAttribArray(this.bvS);
        GLES30.glActiveTexture(33984);
        GLES30.glBindTexture(NB(), i);
        GLES30.glUniform1i(this.bvT, 0);
        Ny();
        Nz();
        NA();
        GLES30.glDisableVertexAttribArray(this.bvR);
        GLES30.glDisableVertexAttribArray(this.bvS);
        GLES30.glBindTexture(NB(), 0);
        GLES30.glUseProgram(0);
    }

    public void Ny() {
    }

    protected void Nz() {
        GLES30.glDrawArrays(5, 0, this.mVertexCount);
    }

    public void NA() {
    }

    public int NB() {
        return 3553;
    }

    public void release() {
        if (this.bvP) {
            GLES30.glDeleteProgram(this.mProgramHandle);
            this.mProgramHandle = -1;
        }
        NC();
    }

    public void R(int i, int i2) {
        if (isInitialized()) {
            if (this.bvY != null && (this.bvW != i || this.bvX != i2)) {
                NC();
            }
            if (this.bvY == null) {
                this.bvW = i;
                this.bvX = i2;
                this.bvY = new int[1];
                this.bvZ = new int[1];
                com.baidu.rtc.camera.filter.glfilter.utils.a.a(this.bvY, this.bvZ, i, i2);
            }
        }
    }

    public void NC() {
        if (this.bvP) {
            if (this.bvZ != null) {
                GLES30.glDeleteTextures(1, this.bvZ, 0);
                this.bvZ = null;
            }
            if (this.bvY != null) {
                GLES30.glDeleteFramebuffers(1, this.bvY, 0);
                this.bvY = null;
            }
            this.bvW = -1;
            this.bvW = -1;
        }
    }

    public boolean isInitialized() {
        return this.bvP;
    }

    protected void runPendingOnDrawTasks() {
        while (!this.mRunOnDraw.isEmpty()) {
            this.mRunOnDraw.removeFirst().run();
        }
    }
}

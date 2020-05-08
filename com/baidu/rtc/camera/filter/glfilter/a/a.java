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
    protected String bft;
    protected String bfu;
    protected boolean bvU;
    protected boolean bvV;
    protected int bvW;
    protected int bvX;
    protected int bvY;
    protected int bvZ;
    protected int bwa;
    protected int bwb;
    protected int bwc;
    protected int[] bwd;
    protected int[] bwe;
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
        this.bvV = true;
        this.mCoordsPerVertex = 2;
        this.mVertexCount = com.baidu.rtc.camera.filter.glfilter.utils.b.bwi.length / this.mCoordsPerVertex;
        this.bwb = -1;
        this.bwc = -1;
        this.mContext = context;
        this.mRunOnDraw = new LinkedList<>();
        this.bft = str;
        this.bfu = str2;
        Nw();
    }

    public void Nw() {
        if (!TextUtils.isEmpty(this.bft) && !TextUtils.isEmpty(this.bfu)) {
            this.mProgramHandle = com.baidu.rtc.camera.filter.glfilter.utils.a.createProgram(this.bft, this.bfu);
            this.bvW = GLES30.glGetAttribLocation(this.mProgramHandle, "aPosition");
            this.bvX = GLES30.glGetAttribLocation(this.mProgramHandle, "aTextureCoord");
            this.bvY = GLES30.glGetUniformLocation(this.mProgramHandle, "inputTexture");
            this.bvU = true;
            return;
        }
        this.bvW = -1;
        this.bvX = -1;
        this.bvY = -1;
        this.bvU = false;
    }

    public void P(int i, int i2) {
        this.mImageWidth = i;
        this.mImageHeight = i2;
    }

    public void Q(int i, int i2) {
        this.bvZ = i;
        this.bwa = i2;
    }

    public boolean a(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        if (this.bvU && i != -1 && this.bvV) {
            GLES30.glViewport(0, 0, this.bvZ, this.bwa);
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
        if (i != -1 && this.bwd != null && this.bvU && this.bvV) {
            GLES30.glViewport(0, 0, this.bwb, this.bwc);
            GLES30.glBindFramebuffer(36160, this.bwd[0]);
            GLES30.glUseProgram(this.mProgramHandle);
            runPendingOnDrawTasks();
            c(i, floatBuffer, floatBuffer2);
            GLES30.glBindFramebuffer(36160, 0);
            return this.bwe[0];
        }
        return i;
    }

    protected void c(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        floatBuffer.position(0);
        GLES30.glVertexAttribPointer(this.bvW, this.mCoordsPerVertex, 5126, false, 0, (Buffer) floatBuffer);
        GLES30.glEnableVertexAttribArray(this.bvW);
        floatBuffer2.position(0);
        GLES30.glVertexAttribPointer(this.bvX, 2, 5126, false, 0, (Buffer) floatBuffer2);
        GLES30.glEnableVertexAttribArray(this.bvX);
        GLES30.glActiveTexture(33984);
        GLES30.glBindTexture(NA(), i);
        GLES30.glUniform1i(this.bvY, 0);
        Nx();
        Ny();
        Nz();
        GLES30.glDisableVertexAttribArray(this.bvW);
        GLES30.glDisableVertexAttribArray(this.bvX);
        GLES30.glBindTexture(NA(), 0);
        GLES30.glUseProgram(0);
    }

    public void Nx() {
    }

    protected void Ny() {
        GLES30.glDrawArrays(5, 0, this.mVertexCount);
    }

    public void Nz() {
    }

    public int NA() {
        return 3553;
    }

    public void release() {
        if (this.bvU) {
            GLES30.glDeleteProgram(this.mProgramHandle);
            this.mProgramHandle = -1;
        }
        NB();
    }

    public void R(int i, int i2) {
        if (isInitialized()) {
            if (this.bwd != null && (this.bwb != i || this.bwc != i2)) {
                NB();
            }
            if (this.bwd == null) {
                this.bwb = i;
                this.bwc = i2;
                this.bwd = new int[1];
                this.bwe = new int[1];
                com.baidu.rtc.camera.filter.glfilter.utils.a.a(this.bwd, this.bwe, i, i2);
            }
        }
    }

    public void NB() {
        if (this.bvU) {
            if (this.bwe != null) {
                GLES30.glDeleteTextures(1, this.bwe, 0);
                this.bwe = null;
            }
            if (this.bwd != null) {
                GLES30.glDeleteFramebuffers(1, this.bwd, 0);
                this.bwd = null;
            }
            this.bwb = -1;
            this.bwb = -1;
        }
    }

    public boolean isInitialized() {
        return this.bvU;
    }

    protected void runPendingOnDrawTasks() {
        while (!this.mRunOnDraw.isEmpty()) {
            this.mRunOnDraw.removeFirst().run();
        }
    }
}

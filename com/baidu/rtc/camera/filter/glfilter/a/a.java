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
    protected boolean bIl;
    protected boolean bIm;
    protected int bIn;
    protected int bIo;
    protected int bIp;
    protected int bIq;
    protected int bIr;
    protected int bIs;
    protected int bIt;
    protected int[] bIu;
    protected int[] bIv;
    protected String brS;
    protected String brT;
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
        this.bIm = true;
        this.mCoordsPerVertex = 2;
        this.mVertexCount = com.baidu.rtc.camera.filter.glfilter.utils.b.bIz.length / this.mCoordsPerVertex;
        this.bIs = -1;
        this.bIt = -1;
        this.mContext = context;
        this.mRunOnDraw = new LinkedList<>();
        this.brS = str;
        this.brT = str2;
        QP();
    }

    public void QP() {
        if (!TextUtils.isEmpty(this.brS) && !TextUtils.isEmpty(this.brT)) {
            this.mProgramHandle = com.baidu.rtc.camera.filter.glfilter.utils.a.createProgram(this.brS, this.brT);
            this.bIn = GLES30.glGetAttribLocation(this.mProgramHandle, "aPosition");
            this.bIo = GLES30.glGetAttribLocation(this.mProgramHandle, "aTextureCoord");
            this.bIp = GLES30.glGetUniformLocation(this.mProgramHandle, "inputTexture");
            this.bIl = true;
            return;
        }
        this.bIn = -1;
        this.bIo = -1;
        this.bIp = -1;
        this.bIl = false;
    }

    public void U(int i, int i2) {
        this.mImageWidth = i;
        this.mImageHeight = i2;
    }

    public void V(int i, int i2) {
        this.bIq = i;
        this.bIr = i2;
    }

    public boolean a(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        if (this.bIl && i != -1 && this.bIm) {
            GLES30.glViewport(0, 0, this.bIq, this.bIr);
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
        if (i != -1 && this.bIu != null && this.bIl && this.bIm) {
            GLES30.glViewport(0, 0, this.bIs, this.bIt);
            GLES30.glBindFramebuffer(36160, this.bIu[0]);
            GLES30.glUseProgram(this.mProgramHandle);
            runPendingOnDrawTasks();
            c(i, floatBuffer, floatBuffer2);
            GLES30.glBindFramebuffer(36160, 0);
            return this.bIv[0];
        }
        return i;
    }

    protected void c(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        floatBuffer.position(0);
        GLES30.glVertexAttribPointer(this.bIn, this.mCoordsPerVertex, 5126, false, 0, (Buffer) floatBuffer);
        GLES30.glEnableVertexAttribArray(this.bIn);
        floatBuffer2.position(0);
        GLES30.glVertexAttribPointer(this.bIo, 2, 5126, false, 0, (Buffer) floatBuffer2);
        GLES30.glEnableVertexAttribArray(this.bIo);
        GLES30.glActiveTexture(33984);
        GLES30.glBindTexture(QT(), i);
        GLES30.glUniform1i(this.bIp, 0);
        QQ();
        QR();
        QS();
        GLES30.glDisableVertexAttribArray(this.bIn);
        GLES30.glDisableVertexAttribArray(this.bIo);
        GLES30.glBindTexture(QT(), 0);
        GLES30.glUseProgram(0);
    }

    public void QQ() {
    }

    protected void QR() {
        GLES30.glDrawArrays(5, 0, this.mVertexCount);
    }

    public void QS() {
    }

    public int QT() {
        return 3553;
    }

    public void release() {
        if (this.bIl) {
            GLES30.glDeleteProgram(this.mProgramHandle);
            this.mProgramHandle = -1;
        }
        QU();
    }

    public void W(int i, int i2) {
        if (isInitialized()) {
            if (this.bIu != null && (this.bIs != i || this.bIt != i2)) {
                QU();
            }
            if (this.bIu == null) {
                this.bIs = i;
                this.bIt = i2;
                this.bIu = new int[1];
                this.bIv = new int[1];
                com.baidu.rtc.camera.filter.glfilter.utils.a.a(this.bIu, this.bIv, i, i2);
            }
        }
    }

    public void QU() {
        if (this.bIl) {
            if (this.bIv != null) {
                GLES30.glDeleteTextures(1, this.bIv, 0);
                this.bIv = null;
            }
            if (this.bIu != null) {
                GLES30.glDeleteFramebuffers(1, this.bIu, 0);
                this.bIu = null;
            }
            this.bIs = -1;
            this.bIs = -1;
        }
    }

    public boolean isInitialized() {
        return this.bIl;
    }

    protected void runPendingOnDrawTasks() {
        while (!this.mRunOnDraw.isEmpty()) {
            this.mRunOnDraw.removeFirst().run();
        }
    }
}

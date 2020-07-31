package com.baidu.rtc.camera.filter.glfilter.a;

import android.content.Context;
import android.opengl.GLES30;
import android.text.TextUtils;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.util.LinkedList;
/* loaded from: classes7.dex */
public class a {
    protected String TAG;
    protected boolean bIK;
    protected boolean bIL;
    protected int bIM;
    protected int bIN;
    protected int bIO;
    protected int bIP;
    protected int bIQ;
    protected int bIR;
    protected int bIS;
    protected int[] bIT;
    protected int[] bIU;
    protected String bsn;
    protected String bso;
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
        this.bIL = true;
        this.mCoordsPerVertex = 2;
        this.mVertexCount = com.baidu.rtc.camera.filter.glfilter.utils.b.bIY.length / this.mCoordsPerVertex;
        this.bIR = -1;
        this.bIS = -1;
        this.mContext = context;
        this.mRunOnDraw = new LinkedList<>();
        this.bsn = str;
        this.bso = str2;
        Re();
    }

    public void Re() {
        if (!TextUtils.isEmpty(this.bsn) && !TextUtils.isEmpty(this.bso)) {
            this.mProgramHandle = com.baidu.rtc.camera.filter.glfilter.utils.a.createProgram(this.bsn, this.bso);
            this.bIM = GLES30.glGetAttribLocation(this.mProgramHandle, "aPosition");
            this.bIN = GLES30.glGetAttribLocation(this.mProgramHandle, "aTextureCoord");
            this.bIO = GLES30.glGetUniformLocation(this.mProgramHandle, "inputTexture");
            this.bIK = true;
            return;
        }
        this.bIM = -1;
        this.bIN = -1;
        this.bIO = -1;
        this.bIK = false;
    }

    public void U(int i, int i2) {
        this.mImageWidth = i;
        this.mImageHeight = i2;
    }

    public void V(int i, int i2) {
        this.bIP = i;
        this.bIQ = i2;
    }

    public boolean a(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        if (this.bIK && i != -1 && this.bIL) {
            GLES30.glViewport(0, 0, this.bIP, this.bIQ);
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
        if (i != -1 && this.bIT != null && this.bIK && this.bIL) {
            GLES30.glViewport(0, 0, this.bIR, this.bIS);
            GLES30.glBindFramebuffer(36160, this.bIT[0]);
            GLES30.glUseProgram(this.mProgramHandle);
            runPendingOnDrawTasks();
            c(i, floatBuffer, floatBuffer2);
            GLES30.glBindFramebuffer(36160, 0);
            return this.bIU[0];
        }
        return i;
    }

    protected void c(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        floatBuffer.position(0);
        GLES30.glVertexAttribPointer(this.bIM, this.mCoordsPerVertex, 5126, false, 0, (Buffer) floatBuffer);
        GLES30.glEnableVertexAttribArray(this.bIM);
        floatBuffer2.position(0);
        GLES30.glVertexAttribPointer(this.bIN, 2, 5126, false, 0, (Buffer) floatBuffer2);
        GLES30.glEnableVertexAttribArray(this.bIN);
        GLES30.glActiveTexture(33984);
        GLES30.glBindTexture(Ri(), i);
        GLES30.glUniform1i(this.bIO, 0);
        Rf();
        Rg();
        Rh();
        GLES30.glDisableVertexAttribArray(this.bIM);
        GLES30.glDisableVertexAttribArray(this.bIN);
        GLES30.glBindTexture(Ri(), 0);
        GLES30.glUseProgram(0);
    }

    public void Rf() {
    }

    protected void Rg() {
        GLES30.glDrawArrays(5, 0, this.mVertexCount);
    }

    public void Rh() {
    }

    public int Ri() {
        return 3553;
    }

    public void release() {
        if (this.bIK) {
            GLES30.glDeleteProgram(this.mProgramHandle);
            this.mProgramHandle = -1;
        }
        Rj();
    }

    public void W(int i, int i2) {
        if (isInitialized()) {
            if (this.bIT != null && (this.bIR != i || this.bIS != i2)) {
                Rj();
            }
            if (this.bIT == null) {
                this.bIR = i;
                this.bIS = i2;
                this.bIT = new int[1];
                this.bIU = new int[1];
                com.baidu.rtc.camera.filter.glfilter.utils.a.a(this.bIT, this.bIU, i, i2);
            }
        }
    }

    public void Rj() {
        if (this.bIK) {
            if (this.bIU != null) {
                GLES30.glDeleteTextures(1, this.bIU, 0);
                this.bIU = null;
            }
            if (this.bIT != null) {
                GLES30.glDeleteFramebuffers(1, this.bIT, 0);
                this.bIT = null;
            }
            this.bIR = -1;
            this.bIR = -1;
        }
    }

    public boolean isInitialized() {
        return this.bIK;
    }

    protected void runPendingOnDrawTasks() {
        while (!this.mRunOnDraw.isEmpty()) {
            this.mRunOnDraw.removeFirst().run();
        }
    }
}

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
    protected int bDA;
    protected int bDB;
    protected int bDC;
    protected int bDD;
    protected int bDE;
    protected int bDF;
    protected int[] bDG;
    protected int[] bDH;
    protected boolean bDx;
    protected boolean bDy;
    protected int bDz;
    protected String bmS;
    protected String bmT;
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
        this.bDy = true;
        this.mCoordsPerVertex = 2;
        this.mVertexCount = com.baidu.rtc.camera.filter.glfilter.utils.b.bDL.length / this.mCoordsPerVertex;
        this.bDE = -1;
        this.bDF = -1;
        this.mContext = context;
        this.mRunOnDraw = new LinkedList<>();
        this.bmS = str;
        this.bmT = str2;
        PJ();
    }

    public void PJ() {
        if (!TextUtils.isEmpty(this.bmS) && !TextUtils.isEmpty(this.bmT)) {
            this.mProgramHandle = com.baidu.rtc.camera.filter.glfilter.utils.a.createProgram(this.bmS, this.bmT);
            this.bDz = GLES30.glGetAttribLocation(this.mProgramHandle, "aPosition");
            this.bDA = GLES30.glGetAttribLocation(this.mProgramHandle, "aTextureCoord");
            this.bDB = GLES30.glGetUniformLocation(this.mProgramHandle, "inputTexture");
            this.bDx = true;
            return;
        }
        this.bDz = -1;
        this.bDA = -1;
        this.bDB = -1;
        this.bDx = false;
    }

    public void S(int i, int i2) {
        this.mImageWidth = i;
        this.mImageHeight = i2;
    }

    public void T(int i, int i2) {
        this.bDC = i;
        this.bDD = i2;
    }

    public boolean a(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        if (this.bDx && i != -1 && this.bDy) {
            GLES30.glViewport(0, 0, this.bDC, this.bDD);
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
        if (i != -1 && this.bDG != null && this.bDx && this.bDy) {
            GLES30.glViewport(0, 0, this.bDE, this.bDF);
            GLES30.glBindFramebuffer(36160, this.bDG[0]);
            GLES30.glUseProgram(this.mProgramHandle);
            runPendingOnDrawTasks();
            c(i, floatBuffer, floatBuffer2);
            GLES30.glBindFramebuffer(36160, 0);
            return this.bDH[0];
        }
        return i;
    }

    protected void c(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        floatBuffer.position(0);
        GLES30.glVertexAttribPointer(this.bDz, this.mCoordsPerVertex, 5126, false, 0, (Buffer) floatBuffer);
        GLES30.glEnableVertexAttribArray(this.bDz);
        floatBuffer2.position(0);
        GLES30.glVertexAttribPointer(this.bDA, 2, 5126, false, 0, (Buffer) floatBuffer2);
        GLES30.glEnableVertexAttribArray(this.bDA);
        GLES30.glActiveTexture(33984);
        GLES30.glBindTexture(PN(), i);
        GLES30.glUniform1i(this.bDB, 0);
        PK();
        PL();
        PM();
        GLES30.glDisableVertexAttribArray(this.bDz);
        GLES30.glDisableVertexAttribArray(this.bDA);
        GLES30.glBindTexture(PN(), 0);
        GLES30.glUseProgram(0);
    }

    public void PK() {
    }

    protected void PL() {
        GLES30.glDrawArrays(5, 0, this.mVertexCount);
    }

    public void PM() {
    }

    public int PN() {
        return 3553;
    }

    public void release() {
        if (this.bDx) {
            GLES30.glDeleteProgram(this.mProgramHandle);
            this.mProgramHandle = -1;
        }
        PO();
    }

    public void U(int i, int i2) {
        if (isInitialized()) {
            if (this.bDG != null && (this.bDE != i || this.bDF != i2)) {
                PO();
            }
            if (this.bDG == null) {
                this.bDE = i;
                this.bDF = i2;
                this.bDG = new int[1];
                this.bDH = new int[1];
                com.baidu.rtc.camera.filter.glfilter.utils.a.a(this.bDG, this.bDH, i, i2);
            }
        }
    }

    public void PO() {
        if (this.bDx) {
            if (this.bDH != null) {
                GLES30.glDeleteTextures(1, this.bDH, 0);
                this.bDH = null;
            }
            if (this.bDG != null) {
                GLES30.glDeleteFramebuffers(1, this.bDG, 0);
                this.bDG = null;
            }
            this.bDE = -1;
            this.bDE = -1;
        }
    }

    public boolean isInitialized() {
        return this.bDx;
    }

    protected void runPendingOnDrawTasks() {
        while (!this.mRunOnDraw.isEmpty()) {
            this.mRunOnDraw.removeFirst().run();
        }
    }
}

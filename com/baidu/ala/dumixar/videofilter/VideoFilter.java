package com.baidu.ala.dumixar.videofilter;

import android.graphics.PointF;
import android.opengl.GLES20;
import android.util.Log;
import com.baidu.ala.dumixar.gles.Drawable2d;
import com.baidu.ala.dumixar.gles.GlUtil;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.util.LinkedList;
/* loaded from: classes7.dex */
public class VideoFilter {
    protected static final String FRAGMENT_SHADER = "precision mediump float;varying vec2 textureCoordinate;uniform sampler2D inputImageTexture;void main() {    gl_FragColor = texture2D(inputImageTexture, textureCoordinate);}";
    protected static final String FRAGMENT_SHADER_WITHOUT_MATRIX = "precision mediump float;varying vec2 textureCoordinate;uniform sampler2D inputImageTexture;void main() {    gl_FragColor = texture2D(inputImageTexture, textureCoordinate);}";
    public static final int NO_IMAGE = -1;
    private static final String TAG = "VideoFilter";
    protected static final String VERTEX_SHADER = "uniform mat4 uMVPMatrix;uniform mat4 uTexMatrix;attribute vec4 position;attribute vec4 inputTextureCoordinate;varying vec2 textureCoordinate;void main() {    gl_Position = uMVPMatrix * position;    textureCoordinate = (uTexMatrix * inputTextureCoordinate).xy;}";
    protected static final String VERTEX_SHADER_WITHOUT_MATRIX = "attribute vec4 position;attribute vec4 inputTextureCoordinate;varying vec2 textureCoordinate;void main() {    gl_Position = position;    textureCoordinate = inputTextureCoordinate.xy;}";
    private int mAttribPosition;
    private int mAttribTextureCoord;
    private String mFragmentShader;
    protected boolean mIsInitialized;
    protected float[] mMvpMatrix;
    protected int mOutputHeight;
    protected int mOutputWidth;
    private int mProgramHandle;
    protected final Drawable2d mRectDrawable;
    private final LinkedList<Runnable> mRunOnDraw;
    protected float[] mTexMatrix;
    protected int mTextureTarget;
    private int mUniformInputTexture;
    protected int mUniformMVPMatrix;
    protected int mUniformTexMatrix;
    private String mVertexShader;

    public VideoFilter() {
        this(VERTEX_SHADER, "precision mediump float;varying vec2 textureCoordinate;uniform sampler2D inputImageTexture;void main() {    gl_FragColor = texture2D(inputImageTexture, textureCoordinate);}");
    }

    public VideoFilter(String str, String str2) {
        this.mRectDrawable = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
        this.mVertexShader = null;
        this.mFragmentShader = null;
        this.mMvpMatrix = null;
        this.mTexMatrix = null;
        this.mRunOnDraw = new LinkedList<>();
        this.mTextureTarget = 3553;
        this.mVertexShader = str;
        this.mFragmentShader = str2;
    }

    public final void init() {
        if (!this.mIsInitialized) {
            onInit();
            this.mIsInitialized = true;
            onInitialized();
        }
    }

    protected void onInit() {
        this.mProgramHandle = GlUtil.createProgram(this.mVertexShader, this.mFragmentShader);
        if (this.mProgramHandle == 0) {
            throw new RuntimeException("Unable to create program");
        }
        this.mAttribPosition = GLES20.glGetAttribLocation(this.mProgramHandle, "position");
        GlUtil.checkLocation(this.mAttribPosition, "position");
        this.mAttribTextureCoord = GLES20.glGetAttribLocation(this.mProgramHandle, "inputTextureCoordinate");
        GlUtil.checkLocation(this.mAttribTextureCoord, "inputTextureCoordinate");
        this.mUniformMVPMatrix = GLES20.glGetUniformLocation(this.mProgramHandle, "uMVPMatrix");
        GlUtil.checkGlError("getting location of uMVPMatrix");
        this.mUniformTexMatrix = GLES20.glGetUniformLocation(this.mProgramHandle, "uTexMatrix");
        GlUtil.checkGlError("getting location of uTexMatrix");
        this.mUniformInputTexture = GLES20.glGetUniformLocation(this.mProgramHandle, "inputImageTexture");
        GlUtil.checkLocation(this.mUniformInputTexture, "inputImageTexture");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onInitialized() {
        this.mOutputWidth = 0;
        this.mOutputHeight = 0;
    }

    public void release() {
        Log.d(TAG, "deleting program " + this.mProgramHandle);
        GLES20.glDeleteProgram(this.mProgramHandle);
        this.mIsInitialized = false;
        this.mProgramHandle = -1;
        onReleased();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onReleased() {
        this.mOutputWidth = 0;
        this.mOutputHeight = 0;
    }

    public void onInputSizeChanged(int i, int i2) {
    }

    public void onOutputSizeChanged(int i, int i2) {
        this.mOutputWidth = i;
        this.mOutputHeight = i2;
    }

    public void setMVPMatrix(float[] fArr) {
        this.mMvpMatrix = fArr;
    }

    public void setTextureMatrix(float[] fArr) {
        this.mTexMatrix = fArr;
    }

    public void setInputTextureType(int i) {
        this.mTextureTarget = i;
    }

    private void runPendingOnDrawTasks() {
        synchronized (this.mRunOnDraw) {
            while (!this.mRunOnDraw.isEmpty()) {
                this.mRunOnDraw.removeFirst().run();
            }
        }
    }

    public void draw(int i) {
        draw(i, 0);
    }

    public void draw(int i, int i2) {
        if (this.mMvpMatrix == null) {
            this.mMvpMatrix = (float[]) GlUtil.IDENTITY_MATRIX.clone();
        }
        if (this.mTexMatrix == null) {
            this.mTexMatrix = (float[]) GlUtil.IDENTITY_MATRIX.clone();
        }
        GlUtil.checkGlError("draw start");
        GLES20.glBindFramebuffer(36160, i2);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glViewport(0, 0, this.mOutputWidth, this.mOutputHeight);
        GLES20.glUseProgram(this.mProgramHandle);
        GlUtil.checkGlError("glUseProgram");
        runPendingOnDrawTasks();
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(this.mTextureTarget, i);
        GLES20.glUniform1i(this.mUniformInputTexture, 0);
        if (this.mUniformMVPMatrix >= 0) {
            GLES20.glUniformMatrix4fv(this.mUniformMVPMatrix, 1, false, this.mMvpMatrix, 0);
            GlUtil.checkGlError("glUniformMatrix4fv for mMvpMatrix");
        }
        if (this.mUniformTexMatrix >= 0) {
            GLES20.glUniformMatrix4fv(this.mUniformTexMatrix, 1, false, this.mTexMatrix, 0);
            GlUtil.checkGlError("glUniformMatrix4fv for mTexMatrix");
        }
        GLES20.glEnableVertexAttribArray(this.mAttribPosition);
        GlUtil.checkGlError("glEnableVertexAttribArray");
        GLES20.glVertexAttribPointer(this.mAttribPosition, 2, 5126, false, 0, (Buffer) this.mRectDrawable.getVertexArray());
        GlUtil.checkGlError("glVertexAttribPointer");
        GLES20.glEnableVertexAttribArray(this.mAttribTextureCoord);
        GlUtil.checkGlError("glEnableVertexAttribArray");
        GLES20.glVertexAttribPointer(this.mAttribTextureCoord, 2, 5126, false, 0, (Buffer) this.mRectDrawable.getTexCoordArray());
        GlUtil.checkGlError("glVertexAttribPointer");
        onDrawPre();
        GLES20.glDrawArrays(5, 0, 4);
        GlUtil.checkGlError("glDrawArrays");
        GLES20.glDisableVertexAttribArray(this.mAttribPosition);
        GLES20.glDisableVertexAttribArray(this.mAttribTextureCoord);
        GLES20.glBindTexture(this.mTextureTarget, 0);
        GLES20.glUseProgram(0);
    }

    protected void onDrawPre() {
    }

    public boolean isInitialized() {
        return this.mIsInitialized;
    }

    public int getOutputWidth() {
        return this.mOutputWidth;
    }

    public int getOutputHeight() {
        return this.mOutputHeight;
    }

    public int getProgram() {
        return this.mProgramHandle;
    }

    public int getAttribPosition() {
        return this.mAttribPosition;
    }

    public int getAttribTextureCoordinate() {
        return this.mAttribTextureCoord;
    }

    public int getUniformTexture() {
        return this.mUniformInputTexture;
    }

    public int getUniformMvpMatrix() {
        return this.mUniformMVPMatrix;
    }

    public int getUniformTexMatrix() {
        return this.mUniformTexMatrix;
    }

    protected void setInteger(final int i, final int i2) {
        runOnDraw(new Runnable() { // from class: com.baidu.ala.dumixar.videofilter.VideoFilter.1
            @Override // java.lang.Runnable
            public void run() {
                GLES20.glUniform1i(i, i2);
            }
        });
    }

    public void setFloat(final int i, final float f) {
        runOnDraw(new Runnable() { // from class: com.baidu.ala.dumixar.videofilter.VideoFilter.2
            @Override // java.lang.Runnable
            public void run() {
                GLES20.glUniform1f(i, f);
            }
        });
    }

    protected void setFloatVec2(final int i, final float[] fArr) {
        runOnDraw(new Runnable() { // from class: com.baidu.ala.dumixar.videofilter.VideoFilter.3
            @Override // java.lang.Runnable
            public void run() {
                GLES20.glUniform2fv(i, 1, FloatBuffer.wrap(fArr));
            }
        });
    }

    protected void setFloatVec3(final int i, final float[] fArr) {
        runOnDraw(new Runnable() { // from class: com.baidu.ala.dumixar.videofilter.VideoFilter.4
            @Override // java.lang.Runnable
            public void run() {
                GLES20.glUniform3fv(i, 1, FloatBuffer.wrap(fArr));
            }
        });
    }

    protected void setFloatVec4(final int i, final float[] fArr) {
        runOnDraw(new Runnable() { // from class: com.baidu.ala.dumixar.videofilter.VideoFilter.5
            @Override // java.lang.Runnable
            public void run() {
                GLES20.glUniform4fv(i, 1, FloatBuffer.wrap(fArr));
            }
        });
    }

    protected void setFloatArray(final int i, final float[] fArr) {
        runOnDraw(new Runnable() { // from class: com.baidu.ala.dumixar.videofilter.VideoFilter.6
            @Override // java.lang.Runnable
            public void run() {
                GLES20.glUniform1fv(i, fArr.length, FloatBuffer.wrap(fArr));
            }
        });
    }

    protected void setPoint(final int i, final PointF pointF) {
        runOnDraw(new Runnable() { // from class: com.baidu.ala.dumixar.videofilter.VideoFilter.7
            @Override // java.lang.Runnable
            public void run() {
                GLES20.glUniform2fv(i, 1, new float[]{pointF.x, pointF.y}, 0);
            }
        });
    }

    protected void setUniformMatrix3f(final int i, final float[] fArr) {
        runOnDraw(new Runnable() { // from class: com.baidu.ala.dumixar.videofilter.VideoFilter.8
            @Override // java.lang.Runnable
            public void run() {
                GLES20.glUniformMatrix3fv(i, 1, false, fArr, 0);
            }
        });
    }

    protected void setUniformMatrix4f(final int i, final float[] fArr) {
        runOnDraw(new Runnable() { // from class: com.baidu.ala.dumixar.videofilter.VideoFilter.9
            @Override // java.lang.Runnable
            public void run() {
                GLES20.glUniformMatrix4fv(i, 1, false, fArr, 0);
            }
        });
    }

    protected void runOnDraw(Runnable runnable) {
        synchronized (this.mRunOnDraw) {
            this.mRunOnDraw.addLast(runnable);
        }
    }
}

package com.baidu.ala.recorder.video.gles;

import android.opengl.GLES20;
import android.util.Log;
import com.baidu.ala.helper.AlaLiveShaderUtil;
import com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class Texture2dProgram {
    private static final String FRAGMENT_SHADER_2D = "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nvoid main() {\n    gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n";
    private static final String FRAGMENT_SHADER_EXT = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n    gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n";
    private static final String FRAGMENT_SHADER_EXT_BW = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n    vec4 tc = texture2D(sTexture, vTextureCoord);\n    float color = tc.r * 0.3 + tc.g * 0.59 + tc.b * 0.11;\n    gl_FragColor = vec4(color, color, color, 1.0);\n}\n";
    private static final String FRAGMENT_SHADER_EXT_FILT = "#extension GL_OES_EGL_image_external : require\n#define KERNEL_SIZE 9\nprecision highp float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nuniform float uKernel[KERNEL_SIZE];\nuniform vec2 uTexOffset[KERNEL_SIZE];\nuniform float uColorAdjust;\nvoid main() {\n    int i = 0;\n    vec4 sum = vec4(0.0);\n    if (vTextureCoord.x < vTextureCoord.y - 0.005) {\n        for (i = 0; i < KERNEL_SIZE; i++) {\n            vec4 texc = texture2D(sTexture, vTextureCoord + uTexOffset[i]);\n            sum += texc * uKernel[i];\n        }\n    sum += uColorAdjust;\n    } else if (vTextureCoord.x > vTextureCoord.y + 0.005) {\n        sum = texture2D(sTexture, vTextureCoord);\n    } else {\n        sum.r = 1.0;\n    }\n    gl_FragColor = sum;\n}\n";
    public static final int KERNEL_SIZE = 9;
    private static final String TAG = "Grafika";
    private static final String VERTEX_SHADER = "uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n";
    int height;
    private float mColorAdjust;
    private int mParamsLocation2;
    private int mPowerLevelId;
    private int mProgramHandle;
    private ProgramType mProgramType;
    private int mSingleStepOffsetLocation;
    private float[] mTexOffset;
    private int mTextureTarget;
    private int maPositionLoc;
    private int maTextureCoordLoc;
    private int muColorAdjustLoc;
    private int muKernelLoc;
    private int muMVPMatrixLoc;
    private int muTexMatrixLoc;
    private int muTexOffsetLoc;
    int width;
    private int mInputWidth = 480;
    private int mInputHeight = 368;
    private float[] mKernel = new float[9];
    private int mParamsLocation = -1;
    private int mPowerLevel = 0;
    private final LinkedList<Runnable> mRunOnDraw = new LinkedList<>();

    /* loaded from: classes2.dex */
    public enum ProgramType {
        TEXTURE_2D,
        TEXTURE_EXT,
        TEXTURE_EXT_BW,
        TEXTURE_EXT_FILT,
        TEXTURE_EXT_MAGIC_2
    }

    public void setInputWH(int i, int i2) {
        this.mInputWidth = i;
        this.mInputHeight = i2;
        setFloatVec2(this.mSingleStepOffsetLocation, new float[]{2.0f / this.mInputWidth, 2.0f / this.mInputHeight});
    }

    public Texture2dProgram(ProgramType programType) {
        this.mSingleStepOffsetLocation = -1;
        this.mParamsLocation2 = -1;
        this.mPowerLevelId = -1;
        this.mProgramType = programType;
        switch (programType) {
            case TEXTURE_2D:
                this.mTextureTarget = 3553;
                this.mProgramHandle = GlUtil.createProgram(VERTEX_SHADER, FRAGMENT_SHADER_2D);
                break;
            case TEXTURE_EXT:
                this.mTextureTarget = 36197;
                this.mProgramHandle = GlUtil.createProgram(VERTEX_SHADER, FRAGMENT_SHADER_EXT);
                break;
            case TEXTURE_EXT_BW:
                this.mTextureTarget = 36197;
                this.mProgramHandle = GlUtil.createProgram(VERTEX_SHADER, FRAGMENT_SHADER_EXT_BW);
                break;
            case TEXTURE_EXT_FILT:
                this.mTextureTarget = 36197;
                this.mProgramHandle = GlUtil.createProgram(VERTEX_SHADER, FRAGMENT_SHADER_EXT_FILT);
                break;
            case TEXTURE_EXT_MAGIC_2:
                this.mTextureTarget = 36197;
                this.mProgramHandle = GlUtil.createProgram(AlaLiveShaderUtil.getStringFromAssert("shader/default_vertex_2.glsl"), AlaLiveShaderUtil.getStringFromAssert("shader/beautify_fragment_adaptive.glsl"));
                this.mParamsLocation2 = GLES20.glGetUniformLocation(this.mProgramHandle, "params");
                GlUtil.checkLocation(this.mParamsLocation2, "params");
                this.mSingleStepOffsetLocation = GLES20.glGetUniformLocation(this.mProgramHandle, "singleStepOffset");
                GlUtil.checkLocation(this.mSingleStepOffsetLocation, "singleStepOffset");
                this.mPowerLevelId = GLES20.glGetUniformLocation(this.mProgramHandle, ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL);
                setPowerLevel(1);
                setBeautyLevel(1);
                break;
            default:
                throw new RuntimeException("Unhandled type " + programType);
        }
        if (this.mProgramHandle == 0) {
            throw new RuntimeException("Unable to create program");
        }
        Log.d("Grafika", "Created program " + this.mProgramHandle + " (" + programType + ")");
        this.maPositionLoc = GLES20.glGetAttribLocation(this.mProgramHandle, "aPosition");
        GlUtil.checkLocation(this.maPositionLoc, "aPosition");
        this.maTextureCoordLoc = GLES20.glGetAttribLocation(this.mProgramHandle, "aTextureCoord");
        GlUtil.checkLocation(this.maTextureCoordLoc, "aTextureCoord");
        this.muMVPMatrixLoc = GLES20.glGetUniformLocation(this.mProgramHandle, "uMVPMatrix");
        GlUtil.checkLocation(this.muMVPMatrixLoc, "uMVPMatrix");
        this.muTexMatrixLoc = GLES20.glGetUniformLocation(this.mProgramHandle, "uTexMatrix");
        GlUtil.checkLocation(this.muTexMatrixLoc, "uTexMatrix");
        this.muKernelLoc = GLES20.glGetUniformLocation(this.mProgramHandle, "uKernel");
        if (this.muKernelLoc < 0) {
            this.muKernelLoc = -1;
            this.muTexOffsetLoc = -1;
            this.muColorAdjustLoc = -1;
            return;
        }
        this.muTexOffsetLoc = GLES20.glGetUniformLocation(this.mProgramHandle, "uTexOffset");
        GlUtil.checkLocation(this.muTexOffsetLoc, "uTexOffset");
        this.muColorAdjustLoc = GLES20.glGetUniformLocation(this.mProgramHandle, "uColorAdjust");
        GlUtil.checkLocation(this.muColorAdjustLoc, "uColorAdjust");
        setKernel(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f}, 0.0f);
        setTexSize(256, 256);
    }

    protected void setFloatVec4(final int i, final float[] fArr) {
        runOnDraw(new Runnable() { // from class: com.baidu.ala.recorder.video.gles.Texture2dProgram.1
            @Override // java.lang.Runnable
            public void run() {
                if (i >= 0) {
                    GLES20.glUniform4fv(i, 1, FloatBuffer.wrap(fArr));
                    GlUtil.checkGlError("glUniform4fv");
                }
            }
        });
    }

    protected void setIntVec2(final int i, final int[] iArr) {
        runOnDraw(new Runnable() { // from class: com.baidu.ala.recorder.video.gles.Texture2dProgram.2
            @Override // java.lang.Runnable
            public void run() {
                if (i >= 0) {
                    GLES20.glUniform2iv(i, 1, IntBuffer.wrap(iArr));
                    GlUtil.checkGlError("glUniform2iv");
                }
            }
        });
    }

    protected void setFloatVec2(final int i, final float[] fArr) {
        runOnDraw(new Runnable() { // from class: com.baidu.ala.recorder.video.gles.Texture2dProgram.3
            @Override // java.lang.Runnable
            public void run() {
                if (i >= 0) {
                    GLES20.glUniform2fv(i, 1, FloatBuffer.wrap(fArr));
                    GlUtil.checkGlError("glUniform2fv");
                }
            }
        });
    }

    protected void setFloat(final int i, final float f) {
        runOnDraw(new Runnable() { // from class: com.baidu.ala.recorder.video.gles.Texture2dProgram.4
            @Override // java.lang.Runnable
            public void run() {
                if (i >= 0) {
                    GLES20.glUniform1f(i, f);
                    GlUtil.checkGlError("glUniform1f");
                }
            }
        });
    }

    private void runOnDraw(Runnable runnable) {
        this.mRunOnDraw.add(runnable);
    }

    public int getPowerLevel() {
        return this.mPowerLevel;
    }

    public void setPowerLevel(int i) {
        this.mPowerLevel = i;
    }

    public void onLowFps(int i) {
        if (this.mPowerLevel < 2) {
            this.mPowerLevel++;
        }
        Log.i("fps=", "onLowFps=" + this.mPowerLevel);
        setIntVec2(this.mPowerLevelId, new int[]{this.mPowerLevel, 0});
    }

    public void setBeautyLevel(int i) {
        setFloatVec2(this.mSingleStepOffsetLocation, new float[]{2.0f / this.mInputWidth, 2.0f / this.mInputHeight});
        setIntVec2(this.mPowerLevelId, new int[]{this.mPowerLevel, 0});
        switch (i) {
            case 0:
                setFloat(this.mParamsLocation, 0.0f);
                break;
            case 1:
                setFloat(this.mParamsLocation, 1.0f);
                break;
            case 2:
                setFloat(this.mParamsLocation, 0.8f);
                break;
            case 3:
                setFloat(this.mParamsLocation, 0.6f);
                break;
            case 4:
                setFloat(this.mParamsLocation, 0.4f);
                break;
            case 5:
                setFloat(this.mParamsLocation, 0.33f);
                break;
        }
        switch (i) {
            case 0:
                setFloatVec4(this.mParamsLocation2, new float[]{0.0f, 0.0f, 0.0f, 0.0f});
                return;
            case 1:
                setFloatVec4(this.mParamsLocation2, new float[]{1.0f, 1.0f, 0.15f, 0.15f});
                return;
            case 2:
                setFloatVec4(this.mParamsLocation2, new float[]{0.8f, 0.9f, 0.2f, 0.2f});
                return;
            case 3:
                setFloatVec4(this.mParamsLocation2, new float[]{0.6f, 0.8f, 0.25f, 0.25f});
                return;
            case 4:
                setFloatVec4(this.mParamsLocation2, new float[]{0.4f, 0.7f, 0.38f, 0.3f});
                return;
            case 5:
                setFloatVec4(this.mParamsLocation2, new float[]{0.33f, 0.63f, 0.4f, 0.35f});
                return;
            default:
                return;
        }
    }

    public int getProgramId() {
        return this.mProgramHandle;
    }

    public void release() {
        Log.d("Grafika", "deleting program " + this.mProgramHandle);
        GLES20.glDeleteProgram(this.mProgramHandle);
        this.mProgramHandle = -1;
    }

    public ProgramType getProgramType() {
        return this.mProgramType;
    }

    public static int createTextureObject(int i) {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GlUtil.checkGlError("glGenTextures");
        int i2 = iArr[0];
        GLES20.glBindTexture(i, i2);
        GlUtil.checkGlError("glBindTexture " + i2);
        GLES20.glTexParameterf(36197, 10241, 9729.0f);
        GLES20.glTexParameterf(36197, 10240, 9729.0f);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        GlUtil.checkGlError("glTexParameter");
        return i2;
    }

    public int createTextureObject() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GlUtil.checkGlError("glGenTextures");
        int i = iArr[0];
        GLES20.glBindTexture(this.mTextureTarget, i);
        GlUtil.checkGlError("glBindTexture " + i);
        GLES20.glTexParameterf(36197, 10241, 9729.0f);
        GLES20.glTexParameterf(36197, 10240, 9729.0f);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        GlUtil.checkGlError("glTexParameter");
        return i;
    }

    public void setKernel(float[] fArr, float f) {
        if (fArr.length != 9) {
            throw new IllegalArgumentException("Kernel size is " + fArr.length + " vs. 9");
        }
        System.arraycopy(fArr, 0, this.mKernel, 0, 9);
        this.mColorAdjust = f;
    }

    public void setTexSize(int i, int i2) {
        this.width = i;
        this.height = i2;
        float f = 1.0f / i;
        float f2 = 1.0f / i2;
        this.mTexOffset = new float[]{-f, -f2, 0.0f, -f2, f, -f2, -f, 0.0f, 0.0f, 0.0f, f, 0.0f, -f, f2, 0.0f, f2, f, f2};
    }

    protected void runPendingOnDrawTasks() {
        while (!this.mRunOnDraw.isEmpty()) {
            this.mRunOnDraw.removeFirst().run();
        }
    }

    public void draw(float[] fArr, FloatBuffer floatBuffer, int i, int i2, int i3, int i4, float[] fArr2, FloatBuffer floatBuffer2, int i5, int i6) {
        GlUtil.checkGlError("draw start");
        GLES20.glUseProgram(this.mProgramHandle);
        GlUtil.checkGlError("glUseProgram");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(this.mTextureTarget, i5);
        runPendingOnDrawTasks();
        GLES20.glUniformMatrix4fv(this.muMVPMatrixLoc, 1, false, fArr, 0);
        GlUtil.checkGlError("glUniformMatrix4fv");
        GLES20.glUniformMatrix4fv(this.muTexMatrixLoc, 1, false, fArr2, 0);
        GlUtil.checkGlError("glUniformMatrix4fv");
        GLES20.glEnableVertexAttribArray(this.maPositionLoc);
        GlUtil.checkGlError("glEnableVertexAttribArray");
        GLES20.glVertexAttribPointer(this.maPositionLoc, i3, 5126, false, i4, (Buffer) floatBuffer);
        GlUtil.checkGlError("glVertexAttribPointer");
        GLES20.glEnableVertexAttribArray(this.maTextureCoordLoc);
        GlUtil.checkGlError("glEnableVertexAttribArray");
        GLES20.glVertexAttribPointer(this.maTextureCoordLoc, 2, 5126, false, i6, (Buffer) floatBuffer2);
        GlUtil.checkGlError("glVertexAttribPointer");
        if (this.muKernelLoc >= 0) {
            GLES20.glUniform1fv(this.muKernelLoc, 9, this.mKernel, 0);
            GLES20.glUniform2fv(this.muTexOffsetLoc, 9, this.mTexOffset, 0);
            GLES20.glUniform1f(this.muColorAdjustLoc, this.mColorAdjust);
        }
        GLES20.glDrawArrays(5, i, i2);
        GlUtil.checkGlError("glDrawArrays");
        GLES20.glDisableVertexAttribArray(this.maPositionLoc);
        GLES20.glDisableVertexAttribArray(this.maTextureCoordLoc);
        GLES20.glBindTexture(this.mTextureTarget, 0);
        GLES20.glUseProgram(0);
    }
}

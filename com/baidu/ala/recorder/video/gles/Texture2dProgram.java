package com.baidu.ala.recorder.video.gles;

import android.annotation.TargetApi;
import android.opengl.GLES20;
import android.util.Log;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.LinkedList;
@TargetApi(16)
/* loaded from: classes5.dex */
public class Texture2dProgram {
    private static final String FRAGMENT_SHADER_2D = "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nvoid main() {\n    gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n";
    private static final String FRAGMENT_SHADER_2D_STICKER = "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nvarying vec2 vTextureCoord2;\nuniform sampler2D sTexture2;\nuniform int stickerEnable;\nbool isOutRect(vec2 coord) {\n    return coord.x < 0.0 || coord.x > 1.0 || coord.y < 0.0 || coord.y > 1.0;\n}\nvoid main() {\n    vec4 texture1 = texture2D(sTexture, vTextureCoord);\n    vec4 texture2 = texture2D(sTexture2, vTextureCoord2);\n    bool isOut1 = isOutRect(vTextureCoord);\n    bool isOut2 = isOutRect(vTextureCoord2);\nif (0 == stickerEnable) {\n    gl_FragColor = texture1;\n} else if (isOut2) {\n    gl_FragColor = texture1;\n} else {\n    gl_FragColor = mix(texture1, texture2, texture2.a);\n}}\n";
    private static final String FRAGMENT_SHADER_EXT = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n    gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n";
    private static final String FRAGMENT_SHADER_EXT_BW = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n    vec4 tc = texture2D(sTexture, vTextureCoord);\n    float color = tc.r * 0.3 + tc.g * 0.59 + tc.b * 0.11;\n    gl_FragColor = vec4(color, color, color, 1.0);\n}\n";
    private static final String FRAGMENT_SHADER_EXT_FILT = "#extension GL_OES_EGL_image_external : require\n#define KERNEL_SIZE 9\nprecision highp float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nuniform float uKernel[KERNEL_SIZE];\nuniform vec2 uTexOffset[KERNEL_SIZE];\nuniform float uColorAdjust;\nvoid main() {\n    int i = 0;\n    vec4 sum = vec4(0.0);\n    if (vTextureCoord.x < vTextureCoord.y - 0.005) {\n        for (i = 0; i < KERNEL_SIZE; i++) {\n            vec4 texc = texture2D(sTexture, vTextureCoord + uTexOffset[i]);\n            sum += texc * uKernel[i];\n        }\n    sum += uColorAdjust;\n    } else if (vTextureCoord.x > vTextureCoord.y + 0.005) {\n        sum = texture2D(sTexture, vTextureCoord);\n    } else {\n        sum.r = 1.0;\n    }\n    gl_FragColor = sum;\n}\n";
    private static final String FRAGMENT_SHADER_MAGIC2_FILTER = "#extension GL_OES_EGL_image_external : require\nprecision lowp float;\nprecision lowp int;\nprecision lowp sampler2D;\nprecision lowp samplerCube;\nuniform samplerExternalOES sTexture;\nuniform vec2 singleStepOffset;\nuniform vec4 params;\nuniform ivec2 level;\n\nvarying  vec2 vTextureCoord;\n\nconst lowp vec3 W = vec3(0.299,0.587,0.114);\nconst mat3 saturateMatrix = mat3(\n1.1102,-0.0598,-0.061,\n-0.0774,1.0826,-0.1186,\n-0.0228,-0.0228,1.1772);\n\nfloat hardlight(float color)\n{\n  if(color <= 0.5)\n  {\n\t\tcolor = color * color * 2.0;\n\t}\n\telse\n\t{\n\t\tcolor = 1.0 - ((1.0 - color)*(1.0 - color) * 2.0);\n\t}\n\treturn color;\n}\n\nvoid main(){\n    vec3 centralColor = texture2D(sTexture, vTextureCoord).rgb;\n    float sampleColor;\n    vec2 blurCoordinates[24];\n    if (params.x==0.0) {\n        gl_FragColor = vec4(centralColor.rgb,1.0);\n    } else {\n        if (level.x==0) {\n        blurCoordinates[0] = vTextureCoord.xy + singleStepOffset * vec2(0.0, -10.0);\n        blurCoordinates[1] = vTextureCoord.xy + singleStepOffset * vec2(0.0, 10.0);\n        blurCoordinates[2] = vTextureCoord.xy + singleStepOffset * vec2(-10.0, 0.0);\n        blurCoordinates[3] = vTextureCoord.xy + singleStepOffset * vec2(10.0, 0.0);\n\n        blurCoordinates[4] = vTextureCoord.xy + singleStepOffset * vec2(5.0, -8.0);\n        blurCoordinates[5] = vTextureCoord.xy + singleStepOffset * vec2(5.0, 8.0);\n        blurCoordinates[6] = vTextureCoord.xy + singleStepOffset * vec2(-5.0, 8.0);\n        blurCoordinates[7] = vTextureCoord.xy + singleStepOffset * vec2(-5.0, -8.0);\n\n        blurCoordinates[8] = vTextureCoord.xy + singleStepOffset * vec2(8.0, -5.0);\n        blurCoordinates[9] = vTextureCoord.xy + singleStepOffset * vec2(8.0, 5.0);\n        blurCoordinates[10] = vTextureCoord.xy + singleStepOffset * vec2(-8.0, 5.0);\n        blurCoordinates[11] = vTextureCoord.xy + singleStepOffset * vec2(-8.0, -5.0);\n\n        blurCoordinates[12] = vTextureCoord.xy + singleStepOffset * vec2(0.0, -6.0);\n        blurCoordinates[13] = vTextureCoord.xy + singleStepOffset * vec2(0.0, 6.0);\n        blurCoordinates[14] = vTextureCoord.xy + singleStepOffset * vec2(6.0, 0.0);\n        blurCoordinates[15] = vTextureCoord.xy + singleStepOffset * vec2(-6.0, 0.0);\n\n        blurCoordinates[16] = vTextureCoord.xy + singleStepOffset * vec2(-4.0, -4.0);\n        blurCoordinates[17] = vTextureCoord.xy + singleStepOffset * vec2(-4.0, 4.0);\n        blurCoordinates[18] = vTextureCoord.xy + singleStepOffset * vec2(4.0, -4.0);\n        blurCoordinates[19] = vTextureCoord.xy + singleStepOffset * vec2(4.0, 4.0);\n\n        blurCoordinates[20] = vTextureCoord.xy + singleStepOffset * vec2(-2.0, -2.0);\n        blurCoordinates[21] = vTextureCoord.xy + singleStepOffset * vec2(-2.0, 2.0);\n        blurCoordinates[22] = vTextureCoord.xy + singleStepOffset * vec2(2.0, -2.0);\n        blurCoordinates[23] = vTextureCoord.xy + singleStepOffset * vec2(2.0, 2.0);\n\n\n        sampleColor = texture2D(sTexture, vTextureCoord).g * 22.0;\n        sampleColor += texture2D(sTexture, blurCoordinates[0]).g;\n        sampleColor += texture2D(sTexture, blurCoordinates[1]).g;\n        sampleColor += texture2D(sTexture, blurCoordinates[2]).g;\n        sampleColor += texture2D(sTexture, blurCoordinates[3]).g;\n        sampleColor += texture2D(sTexture, blurCoordinates[4]).g;\n        sampleColor += texture2D(sTexture, blurCoordinates[5]).g;\n        sampleColor += texture2D(sTexture, blurCoordinates[6]).g;\n        sampleColor += texture2D(sTexture, blurCoordinates[7]).g;\n        sampleColor += texture2D(sTexture, blurCoordinates[8]).g;\n        sampleColor += texture2D(sTexture, blurCoordinates[9]).g;\n        sampleColor += texture2D(sTexture, blurCoordinates[10]).g;\n        sampleColor += texture2D(sTexture, blurCoordinates[11]).g;\n\n        sampleColor += texture2D(sTexture, blurCoordinates[12]).g * 2.0;\n        sampleColor += texture2D(sTexture, blurCoordinates[13]).g * 2.0;\n        sampleColor += texture2D(sTexture, blurCoordinates[14]).g * 2.0;\n        sampleColor += texture2D(sTexture, blurCoordinates[15]).g * 2.0;\n        sampleColor += texture2D(sTexture, blurCoordinates[16]).g * 2.0;\n        sampleColor += texture2D(sTexture, blurCoordinates[17]).g * 2.0;\n        sampleColor += texture2D(sTexture, blurCoordinates[18]).g * 2.0;\n        sampleColor += texture2D(sTexture, blurCoordinates[19]).g * 2.0;\n\n        sampleColor += texture2D(sTexture, blurCoordinates[20]).g * 3.0;\n        sampleColor += texture2D(sTexture, blurCoordinates[21]).g * 3.0;\n        sampleColor += texture2D(sTexture, blurCoordinates[22]).g * 3.0;\n        sampleColor += texture2D(sTexture, blurCoordinates[23]).g * 3.0;\n\n        sampleColor = sampleColor / 62.0;\n        } else if ( level.x == 1 )\n        {\n \tblurCoordinates[0] = vTextureCoord.xy + singleStepOffset * vec2( 5.0, -8.0 );\n \tblurCoordinates[1] = vTextureCoord.xy + singleStepOffset * vec2( 5.0, 8.0 );\n \tblurCoordinates[2] = vTextureCoord.xy + singleStepOffset * vec2( -5.0, 8.0 );\n \tblurCoordinates[3] = vTextureCoord.xy + singleStepOffset * vec2( -5.0, -8.0 );\n \tblurCoordinates[4] = vTextureCoord.xy + singleStepOffset * vec2( 8.0, -5.0 );\n \tblurCoordinates[5] = vTextureCoord.xy + singleStepOffset * vec2( 8.0, 5.0 );\n \tblurCoordinates[6] = vTextureCoord.xy + singleStepOffset * vec2( -8.0, 5.0 );\n \tblurCoordinates[7] = vTextureCoord.xy + singleStepOffset * vec2( -8.0, -5.0 );\n \tblurCoordinates[8] = vTextureCoord.xy + singleStepOffset * vec2( -4.0, -4.0 );\n \tblurCoordinates[9] = vTextureCoord.xy + singleStepOffset * vec2( -4.0, 4.0 );\n \tblurCoordinates[10] = vTextureCoord.xy + singleStepOffset * vec2( 4.0, -4.0 );\n \tblurCoordinates[11] = vTextureCoord.xy + singleStepOffset * vec2( 4.0, 4.0 );\n \tsampleColor\t= texture2D( sTexture, vTextureCoord ).g * 22.0;\n \tsampleColor\t+= texture2D( sTexture, blurCoordinates[0] ).g;\n \tsampleColor\t+= texture2D( sTexture, blurCoordinates[1] ).g;\n \tsampleColor\t+= texture2D( sTexture, blurCoordinates[2] ).g;\n \tsampleColor\t+= texture2D( sTexture, blurCoordinates[3] ).g;\n \tsampleColor\t+= texture2D( sTexture, blurCoordinates[4] ).g;\n \tsampleColor\t+= texture2D( sTexture, blurCoordinates[5] ).g;\n \tsampleColor\t+= texture2D( sTexture, blurCoordinates[6] ).g;\n \tsampleColor\t+= texture2D( sTexture, blurCoordinates[7] ).g;\n\n \tsampleColor\t+= texture2D( sTexture, blurCoordinates[8] ).g * 2.0;\n \tsampleColor\t+= texture2D( sTexture, blurCoordinates[9] ).g * 2.0;\n \tsampleColor\t+= texture2D( sTexture, blurCoordinates[10] ).g * 2.0;\n \tsampleColor\t+= texture2D( sTexture, blurCoordinates[11] ).g * 2.0;\n\n         \tsampleColor\t= sampleColor / 38.0;\n\n        } else if ( level.x == 2 ) {\n         \tblurCoordinates[8] = vTextureCoord.xy + singleStepOffset * vec2( -4.0, -4.0 );\n         \tblurCoordinates[9] = vTextureCoord.xy + singleStepOffset * vec2( -4.0, 4.0 );\n         \tblurCoordinates[10] = vTextureCoord.xy + singleStepOffset * vec2( 4.0, -4.0 );\n         \tblurCoordinates[11] = vTextureCoord.xy + singleStepOffset * vec2( 4.0, 4.0 );\n            sampleColor\t= texture2D( sTexture, vTextureCoord ).g * 12.0;\n         \tsampleColor\t+= texture2D( sTexture, blurCoordinates[8] ).g * 2.0;\n         \tsampleColor\t+= texture2D( sTexture, blurCoordinates[9] ).g * 2.0;\n         \tsampleColor\t+= texture2D( sTexture, blurCoordinates[10] ).g * 2.0;\n         \tsampleColor\t+= texture2D( sTexture, blurCoordinates[11] ).g * 2.0;\n         \tsampleColor\t= sampleColor / 20.0;\n        } else {\n            sampleColor\t=  centralColor.g;\n        }\n\n    \tfloat highpass = centralColor.g - sampleColor + 0.5;\n\n        for(int i = 0; i < 5 ;i++)\n        {\n            highpass = hardlight(highpass);\n        }\n        float lumance = dot(centralColor, W);\n\n        float alpha = pow(lumance, params.r);\n\n        vec3 smoothColor = centralColor + (centralColor-vec3(highpass))*alpha*0.1;\n\n        smoothColor.r = clamp(pow(smoothColor.r, params.g),0.0,1.0);\n        smoothColor.g = clamp(pow(smoothColor.g, params.g),0.0,1.0);\n        smoothColor.b = clamp(pow(smoothColor.b, params.g),0.0,1.0);\n\n        vec3 lvse = vec3(1.0)-(vec3(1.0)-smoothColor)*(vec3(1.0)-centralColor);\n        vec3 bianliang = max(smoothColor, centralColor);\n        vec3 rouguang = 2.0*centralColor*smoothColor +  centralColor*centralColor - 2.0*centralColor*centralColor*smoothColor;\n\n        gl_FragColor = vec4(mix(centralColor, lvse, alpha), 1.0);\n        gl_FragColor.rgb = mix(gl_FragColor.rgb, bianliang, alpha);\n        gl_FragColor.rgb = mix(gl_FragColor.rgb, rouguang, params.b);\n\n        vec3 satcolor = gl_FragColor.rgb * saturateMatrix;\n        gl_FragColor.rgb = mix(gl_FragColor.rgb, satcolor, params.a);\n    }\n}";
    public static final int KERNEL_SIZE = 9;
    private static final String TAG = "Grafika";
    private static final String VERTEX_SHADER = "uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n";
    private static final String VERTEX_SHADER_STICKER = "uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nuniform mat4 uTexMatrix2;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nattribute vec4 aTextureCoord2;varying vec2 vTextureCoord2;void main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n    vTextureCoord2 = (uTexMatrix2 * aTextureCoord2).xy;\n}\n";
    int height;
    private float mColorAdjust;
    private int mMagic2LevelLocation;
    private int mMagic2ParamsLocation;
    private int mMagic2StepLocation;
    private int mProgramHandle;
    private ProgramType mProgramType;
    private Sticker mSticker;
    private int mStickerEnableLoc;
    private float[] mTexOffset;
    private int mTextureTarget;
    private int maPositionLoc;
    private int maTextureCoordLoc;
    private int maTextureCoordLoc2;
    private int muColorAdjustLoc;
    private int muKernelLoc;
    private int muMVPMatrixLoc;
    private int muTexMatrixLoc;
    private int muTexMatrixLoc2;
    private int muTexOffsetLoc;
    private float[] texMatrix2;
    private int textureLocation;
    private int textureLocation2;
    int width;
    private static final float[] FULL_RECTANGLE_TEX_COORDS = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    private static FloatBuffer vc2 = GlUtil.createFloatBuffer(FULL_RECTANGLE_TEX_COORDS);
    private int mInputWidth = 480;
    private int mInputHeight = 368;
    private float[] mKernel = new float[9];
    private int mMagic2PowerLevel = 0;
    private final LinkedList<Runnable> mRunOnDraw = new LinkedList<>();

    /* loaded from: classes5.dex */
    public enum ProgramType {
        TEXTURE_2D,
        TEXTURE_EXT,
        TEXTURE_EXT_BW,
        TEXTURE_EXT_FILT,
        TEXTURE_EXT_MAGIC_2,
        TEXTURE_2D_STICKER
    }

    public void setSticker(Sticker sticker) {
        this.mSticker = sticker;
    }

    public void setInputWH(int i, int i2) {
        this.mInputWidth = i;
        this.mInputHeight = i2;
        setFloatVec2(this.mMagic2StepLocation, new float[]{2.0f / this.mInputWidth, 2.0f / this.mInputHeight});
    }

    public Texture2dProgram(ProgramType programType) {
        this.textureLocation2 = 0;
        this.textureLocation = 0;
        this.mMagic2StepLocation = -1;
        this.mMagic2ParamsLocation = -1;
        this.mMagic2LevelLocation = -1;
        this.mProgramType = programType;
        switch (programType) {
            case TEXTURE_2D:
                this.mTextureTarget = 3553;
                this.mProgramHandle = GlUtil.createProgram("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n", FRAGMENT_SHADER_2D);
                break;
            case TEXTURE_2D_STICKER:
                this.mTextureTarget = 3553;
                this.mProgramHandle = GlUtil.createProgram(VERTEX_SHADER_STICKER, FRAGMENT_SHADER_2D_STICKER);
                break;
            case TEXTURE_EXT:
                this.mTextureTarget = 36197;
                this.mProgramHandle = GlUtil.createProgram("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n", FRAGMENT_SHADER_EXT);
                break;
            case TEXTURE_EXT_BW:
                this.mTextureTarget = 36197;
                this.mProgramHandle = GlUtil.createProgram("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n", FRAGMENT_SHADER_EXT_BW);
                break;
            case TEXTURE_EXT_FILT:
                this.mTextureTarget = 36197;
                this.mProgramHandle = GlUtil.createProgram("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n", FRAGMENT_SHADER_EXT_FILT);
                break;
            case TEXTURE_EXT_MAGIC_2:
                this.mTextureTarget = 36197;
                this.mProgramHandle = GlUtil.createProgram("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n", FRAGMENT_SHADER_MAGIC2_FILTER);
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
        this.textureLocation = GLES20.glGetUniformLocation(this.mProgramHandle, "sTexture");
        if (programType == ProgramType.TEXTURE_2D_STICKER) {
            this.mStickerEnableLoc = GLES20.glGetUniformLocation(this.mProgramHandle, "stickerEnable");
            this.maTextureCoordLoc2 = GLES20.glGetAttribLocation(this.mProgramHandle, "aTextureCoord2");
            this.textureLocation2 = GLES20.glGetUniformLocation(this.mProgramHandle, "sTexture2");
            GlUtil.checkLocation(this.maTextureCoordLoc2, "aTextureCoord2");
        }
        if (programType == ProgramType.TEXTURE_EXT_MAGIC_2) {
            this.mMagic2ParamsLocation = GLES20.glGetUniformLocation(this.mProgramHandle, "params");
            GlUtil.checkLocation(this.mMagic2ParamsLocation, "params");
            this.mMagic2StepLocation = GLES20.glGetUniformLocation(this.mProgramHandle, "singleStepOffset");
            GlUtil.checkLocation(this.mMagic2StepLocation, "singleStepOffset");
            this.mMagic2LevelLocation = GLES20.glGetUniformLocation(this.mProgramHandle, "level");
            GlUtil.checkLocation(this.mMagic2StepLocation, "level");
            setPowerLevel(1);
            setBeautyLevel(1);
        }
        GlUtil.checkLocation(this.maTextureCoordLoc, "aTextureCoord");
        this.muMVPMatrixLoc = GLES20.glGetUniformLocation(this.mProgramHandle, "uMVPMatrix");
        GlUtil.checkLocation(this.muMVPMatrixLoc, "uMVPMatrix");
        this.muTexMatrixLoc = GLES20.glGetUniformLocation(this.mProgramHandle, "uTexMatrix");
        this.muTexMatrixLoc2 = GLES20.glGetUniformLocation(this.mProgramHandle, "uTexMatrix2");
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

    public void setPowerLevel(int i) {
        this.mMagic2PowerLevel = i;
    }

    public void setBeautyLevel(int i) {
        setFloatVec2(this.mMagic2StepLocation, new float[]{2.0f / this.mInputWidth, 2.0f / this.mInputHeight});
        setIntVec2(this.mMagic2LevelLocation, new int[]{this.mMagic2PowerLevel, 0});
        switch (i) {
            case 0:
                setFloatVec4(this.mMagic2ParamsLocation, new float[]{0.0f, 0.0f, 0.0f, 0.0f});
                return;
            case 1:
                setFloatVec4(this.mMagic2ParamsLocation, new float[]{1.0f, 1.0f, 0.15f, 0.15f});
                return;
            case 2:
                setFloatVec4(this.mMagic2ParamsLocation, new float[]{0.8f, 0.9f, 0.2f, 0.2f});
                return;
            case 3:
                setFloatVec4(this.mMagic2ParamsLocation, new float[]{0.6f, 0.8f, 0.25f, 0.25f});
                return;
            case 4:
                setFloatVec4(this.mMagic2ParamsLocation, new float[]{0.4f, 0.7f, 0.38f, 0.3f});
                return;
            case 5:
                setFloatVec4(this.mMagic2ParamsLocation, new float[]{0.33f, 0.63f, 0.4f, 0.35f});
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
        boolean z;
        GlUtil.checkGlError("draw start");
        GLES20.glUseProgram(this.mProgramHandle);
        GlUtil.checkGlError("glUseProgram");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(this.mTextureTarget, i5);
        GLES20.glUniform1i(this.textureLocation, 0);
        boolean z2 = (this.maTextureCoordLoc2 == 0 || this.mSticker == null) ? false : true;
        int i7 = 0;
        if (z2) {
            this.texMatrix2 = this.mSticker.getMatrix();
            int texture = this.mSticker.getTexture();
            i7 = texture;
            z = z2 & (texture != 0);
        } else {
            z = z2;
        }
        this.mSticker = null;
        if (this.mStickerEnableLoc != 0) {
            GLES20.glUniform1i(this.mStickerEnableLoc, z ? 1 : 0);
        }
        if (z) {
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(3553, i7);
            GLES20.glUniform1i(this.textureLocation2, 1);
        }
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
        if (z) {
            GLES20.glUniformMatrix4fv(this.muTexMatrixLoc2, 1, false, this.texMatrix2, 0);
            GLES20.glEnableVertexAttribArray(this.maTextureCoordLoc2);
            GlUtil.checkGlError("glEnableVertexAttribArray2");
            vc2.position(0);
            GLES20.glVertexAttribPointer(this.maTextureCoordLoc2, 2, 5126, false, i6, (Buffer) vc2);
            GlUtil.checkGlError("glVertexAttribPointer2");
        }
        if (this.muKernelLoc >= 0) {
            GLES20.glUniform1fv(this.muKernelLoc, 9, this.mKernel, 0);
            GLES20.glUniform2fv(this.muTexOffsetLoc, 9, this.mTexOffset, 0);
            GLES20.glUniform1f(this.muColorAdjustLoc, this.mColorAdjust);
        }
        GLES20.glDrawArrays(5, i, i2);
        GlUtil.checkGlError("glDrawArrays");
        GLES20.glDisableVertexAttribArray(this.maPositionLoc);
        GLES20.glDisableVertexAttribArray(this.maTextureCoordLoc);
        if (this.maTextureCoordLoc2 != 0) {
            GLES20.glDisableVertexAttribArray(this.maTextureCoordLoc2);
        }
        GLES20.glBindTexture(this.mTextureTarget, 0);
        GLES20.glUseProgram(0);
    }
}

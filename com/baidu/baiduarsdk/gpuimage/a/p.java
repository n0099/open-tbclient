package com.baidu.baiduarsdk.gpuimage.a;

import android.opengl.GLES20;
import com.coremedia.iso.boxes.FreeSpaceBox;
/* loaded from: classes3.dex */
public class p extends g {
    private int a;
    private int k;
    private int l;
    private int m;
    private float n;
    private float o;
    private float p;
    private float q;

    public p() {
        super("attribute vec4 position;attribute vec4 inputTextureCoordinate;varying vec2 textureCoordinate;void main() {    gl_Position = position;    textureCoordinate = inputTextureCoordinate.xy;}", "varying highp vec2 textureCoordinate;\n\nuniform sampler2D inputImageTexture;\n\nuniform highp vec2 singleStepOffset;\nuniform highp vec4 params;\nuniform highp float brightness;\nuniform lowp float skip;\n\nconst highp vec3 W = vec3(0.299, 0.587, 0.114);\nconst highp mat3 saturateMatrix = mat3(\n    1.1102, -0.0598, -0.061,\n    -0.0774, 1.0826, -0.1186,\n    -0.0228, -0.0228, 1.1772);\nhighp vec2 blurCoordinates[12];\n\n\nvoid main(){\n    highp vec4 tmpTexture = texture2D(inputImageTexture, textureCoordinate);\n    highp vec3 centralColor = tmpTexture.rgb;\n    if (skip == 0.0) {\n        blurCoordinates[0] = textureCoordinate.xy + singleStepOffset * vec2(0.0, -6.0);\n        blurCoordinates[1] = textureCoordinate.xy + singleStepOffset * vec2(0.0, 6.0);\n        blurCoordinates[2] = textureCoordinate.xy + singleStepOffset * vec2(6.0, 0.0);\n        blurCoordinates[3] = textureCoordinate.xy + singleStepOffset * vec2(-6.0, 0.0);\n        blurCoordinates[4] = textureCoordinate.xy + singleStepOffset * vec2(-4.0, -4.0);\n        blurCoordinates[5] = textureCoordinate.xy + singleStepOffset * vec2(-4.0, 4.0);\n        blurCoordinates[6] = textureCoordinate.xy + singleStepOffset * vec2(4.0, -4.0);\n        blurCoordinates[7] = textureCoordinate.xy + singleStepOffset * vec2(4.0, 4.0);\n        blurCoordinates[8] = textureCoordinate.xy + singleStepOffset * vec2(-2.0, -2.0);\n        blurCoordinates[9] = textureCoordinate.xy + singleStepOffset * vec2(-2.0, 2.0);\n        blurCoordinates[10] = textureCoordinate.xy + singleStepOffset * vec2(2.0, -2.0);\n        blurCoordinates[11] = textureCoordinate.xy + singleStepOffset * vec2(2.0, 2.0);\n\n        highp float sampleColor = centralColor.g * 22.0;\n        sampleColor += texture2D(inputImageTexture, blurCoordinates[0]).g * 2.0;\n        sampleColor += texture2D(inputImageTexture, blurCoordinates[1]).g * 2.0;\n        sampleColor += texture2D(inputImageTexture, blurCoordinates[2]).g * 2.0;\n        sampleColor += texture2D(inputImageTexture, blurCoordinates[3]).g * 2.0;\n        sampleColor += texture2D(inputImageTexture, blurCoordinates[4]).g * 2.0;\n        sampleColor += texture2D(inputImageTexture, blurCoordinates[5]).g * 2.0;\n        sampleColor += texture2D(inputImageTexture, blurCoordinates[6]).g * 2.0;\n        sampleColor += texture2D(inputImageTexture, blurCoordinates[7]).g * 2.0;\n        sampleColor += texture2D(inputImageTexture, blurCoordinates[8]).g * 3.0;\n        sampleColor += texture2D(inputImageTexture, blurCoordinates[9]).g * 3.0;\n        sampleColor += texture2D(inputImageTexture, blurCoordinates[10]).g * 3.0;\n        sampleColor += texture2D(inputImageTexture, blurCoordinates[11]).g * 3.0;\n\n        sampleColor = sampleColor / 50.0;\n\n        highp float highPass = clamp(centralColor.g - sampleColor + 0.5, 0.0, 1.0);\n        highPass = mix(1.0 - (1.0 - highPass) * (1.0 - highPass) * 2.0, highPass * highPass * 2.0,                 step(highPass, 0.5));\n        highPass = mix(1.0 - (1.0 - highPass) * (1.0 - highPass) * 2.0, highPass * highPass * 2.0,                 step(highPass, 0.5));\n        highPass = mix(1.0 - (1.0 - highPass) * (1.0 - highPass) * 2.0, highPass * highPass * 2.0,                 step(highPass, 0.5));\n        highPass = mix(1.0 - (1.0 - highPass) * (1.0 - highPass) * 2.0, highPass * highPass * 2.0,                 step(highPass, 0.5));\n\n        highp float luminance = dot(centralColor, W);\n        highp float alpha = pow(luminance, params.r);\n\n        highp vec3 smoothColor = centralColor + (centralColor-vec3(highPass)) * alpha * 0.1;\n        gl_FragColor.rgb = mix(centralColor.rgb, smoothColor, params.g);\n\n        gl_FragColor.rgb = mix(gl_FragColor.rgb * (brightness + 1.0),                 gl_FragColor.rgb * saturateMatrix, params.b);\n        gl_FragColor.a = tmpTexture.a;\n    } else {\n        gl_FragColor.rgb = centralColor.rgb;\n        gl_FragColor.a = tmpTexture.a;\n    }\n}\n");
        this.a = -1;
        this.k = -1;
        this.l = -1;
        this.m = -1;
        this.n = 0.0f;
        this.o = 0.0f;
        this.p = 0.0f;
        this.q = 1.0f;
    }

    private void a(float f, float f2) {
        a(this.k, new float[]{2.0f / f, 2.0f / f2});
    }

    private void b(float f, float f2) {
        b(this.a, new float[]{1.0f - (0.6f * f), f, f2, f2});
    }

    private void k() {
        if (this.n == 0.0f && this.o == 0.0f && this.p == 0.0f) {
            this.q = 1.0f;
        } else {
            this.q = 0.0f;
        }
        a(this.m, this.q);
    }

    @Override // com.baidu.baiduarsdk.gpuimage.a.g
    public void a() {
        super.a();
        this.a = GLES20.glGetUniformLocation(h(), "params");
        this.k = GLES20.glGetUniformLocation(h(), "singleStepOffset");
        this.l = GLES20.glGetUniformLocation(h(), "brightness");
        this.m = GLES20.glGetUniformLocation(h(), FreeSpaceBox.TYPE);
        b(this.o);
        b(this.n, this.p);
    }

    public void a(float f) {
        this.n = Math.max(0.0f, Math.min(1.0f, f));
        k();
        b(this.n, this.p);
    }

    @Override // com.baidu.baiduarsdk.gpuimage.a.g
    public void a(int i, int i2) {
        super.a(i, i2);
        a(i, i2);
    }

    public void b(float f) {
        this.o = Math.max(0.0f, Math.min(1.0f, f));
        k();
        a(this.l, 0.3f * this.o);
    }
}

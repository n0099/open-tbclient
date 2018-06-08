package com.baidu.baiduarsdk.gpuimage.a;
/* loaded from: classes3.dex */
public class i extends t {
    protected float l;

    public i() {
        this(4.0f);
    }

    public i(float f) {
        super(b((int) f, 4.0f), c((int) f, 4.0f), b((int) f, 4.0f), c((int) f, 4.0f));
        this.l = 1.0f;
        this.l = f;
    }

    public static String b(int i, float f) {
        if (i < 1) {
            return "attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n\nuniform float texelWidthOffset;\nuniform float texelHeightOffset;\n\nvarying vec2 textureCoordinate;\nvarying vec2 blurCoordinates[7];\n\nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n    \n    // Calculate the positions for the blur\n   vec2 singleStepOffset = vec2(texelHeightOffset, texelWidthOffset);\n    \n   blurCoordinates[0] = textureCoordinate;   blurCoordinates[1] = textureCoordinate + singleStepOffset * 1.485005;\n   blurCoordinates[2] = textureCoordinate - singleStepOffset * 1.485005;\n   blurCoordinates[3] = textureCoordinate + singleStepOffset * 3.465057;\n   blurCoordinates[4] = textureCoordinate - singleStepOffset * 3.465057;\n   blurCoordinates[5] = textureCoordinate + singleStepOffset * 5.393111;\n   blurCoordinates[6] = textureCoordinate - singleStepOffset * 5.393111;\n}\n";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n\nuniform float texelWidthOffset;\nuniform float texelHeightOffset;\n\nvarying vec2 blurCoordinates[%d];\n\nvoid main()\n{\n    gl_Position = position;\n    \n    vec2 singleStepOffset = vec2(texelWidthOffset, texelHeightOffset);\n", Integer.valueOf((i * 2) + 1)));
        for (int i2 = 0; i2 < (i * 2) + 1; i2++) {
            int i3 = i2 - i;
            if (i3 < 0) {
                sb.append(String.format("    blurCoordinates[%d] = inputTextureCoordinate.xy - singleStepOffset * %f;\n", Integer.valueOf(i2), Float.valueOf(-i3)));
            } else if (i3 > 0) {
                sb.append(String.format("    blurCoordinates[%d] = inputTextureCoordinate.xy + singleStepOffset * %f;\n", Integer.valueOf(i2), Float.valueOf(i3)));
            } else {
                sb.append(String.format("    blurCoordinates[%d] = inputTextureCoordinate.xy;\n", Integer.valueOf(i2)));
            }
        }
        sb.append(String.format("}\n", new Object[0]));
        return sb.toString();
    }

    public static String c(int i, float f) {
        if (i < 1) {
            return "uniform sampler2D inputImageTexture;\n\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 blurCoordinates[7];\n\nvoid main()\n{\n    lowp vec3 sum = vec3(0.0);\n    lowp vec4 fragColor=texture2D(inputImageTexture,textureCoordinate);\n    \n    sum += texture2D(inputImageTexture, blurCoordinates[0]).rgb * 0.098853;\n    sum += texture2D(inputImageTexture, blurCoordinates[1]).rgb * 0.188148;\n    sum += texture2D(inputImageTexture, blurCoordinates[2]).rgb * 0.188148;\n    sum += texture2D(inputImageTexture, blurCoordinates[3]).rgb * 0.154351;\n    sum += texture2D(inputImageTexture, blurCoordinates[4]).rgb * 0.154351;\n    sum += texture2D(inputImageTexture, blurCoordinates[5]).rgb * 0.098795;\n    sum += texture2D(inputImageTexture, blurCoordinates[6]).rgb * 0.098795;\n    gl_FragColor = vec4(sum,fragColor.a);\n}";
        }
        float[] fArr = new float[i + 1];
        float f2 = 0.0f;
        int i2 = 0;
        while (i2 < i + 1) {
            fArr[i2] = (float) ((1.0d / Math.sqrt(6.283185307179586d * Math.pow(f, 2.0d))) * Math.exp((-Math.pow(i2, 2.0d)) / (2.0d * Math.pow(f, 2.0d))));
            float f3 = i2 == 0 ? fArr[i2] + f2 : (float) (f2 + (2.0d * fArr[i2]));
            i2++;
            f2 = f3;
        }
        for (int i3 = 0; i3 < i + 1; i3++) {
            fArr[i3] = fArr[i3] / f2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("uniform sampler2D inputImageTexture;\n\nvarying highp vec2 blurCoordinates[%d];\n\nvoid main()\n{\n   lowp vec4 sum = vec4(0.0);\n", Integer.valueOf((i * 2) + 1)));
        for (int i4 = 0; i4 < (i * 2) + 1; i4++) {
            int i5 = i4 - i;
            if (i5 < 0) {
                sb.append(String.format("    sum += texture2D(inputImageTexture, blurCoordinates[%d]) * %f;\n", Integer.valueOf(i4), Float.valueOf(fArr[-i5])));
            } else {
                sb.append(String.format("    sum += texture2D(inputImageTexture, blurCoordinates[%d]) * %f;\n", Integer.valueOf(i4), Float.valueOf(fArr[i5])));
            }
        }
        sb.append(String.format("    gl_FragColor = sum;\n}\n", new Object[0]));
        return sb.toString();
    }

    public void a(float f) {
        this.l = f;
        a(new Runnable() { // from class: com.baidu.baiduarsdk.gpuimage.a.i.1
            @Override // java.lang.Runnable
            public void run() {
                i.this.o();
            }
        });
    }

    @Override // com.baidu.baiduarsdk.gpuimage.a.t
    public float m() {
        return this.l;
    }

    @Override // com.baidu.baiduarsdk.gpuimage.a.t
    public float n() {
        return this.l;
    }
}

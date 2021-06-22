package com.baidu.pass.main.facesdk.model;
/* loaded from: classes2.dex */
public class BDFaceOcclusion {
    public float chin;
    public float leftCheek;
    public float leftEye;
    public float mouth;
    public float nose;
    public float rightCheek;
    public float rightEye;

    public BDFaceOcclusion(float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        this.leftEye = f2;
        this.rightEye = f3;
        this.nose = f4;
        this.mouth = f5;
        this.leftCheek = f6;
        this.rightCheek = f7;
        this.chin = f8;
    }
}

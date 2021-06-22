package com.baidu.pass.biometrics.face.liveness.utils.enums;
/* loaded from: classes2.dex */
public enum PassFaceRecogType {
    RECOG_TYPE_BDUSS("recog_type_bduss", 1),
    RECOG_TYPE_AUTHTOKEN("recog_type_authtoken", 2),
    RECOG_TYPE_CERTINFO("recog_type_certinfo", 3),
    RECOG_TYPE_FACEDETECT("recog_type_facedetect", 4),
    RECOG_TYPE_OUTER("recog_type_outer", 5),
    RECOG_TYPE_FACEIMAGE("recog_type_facedimage", 6);
    

    /* renamed from: a  reason: collision with root package name */
    public String f9177a;

    /* renamed from: b  reason: collision with root package name */
    public int f9178b;

    PassFaceRecogType(String str, int i2) {
        this.f9177a = str;
        this.f9178b = i2;
    }

    public String getRecogTypeName() {
        return this.f9177a;
    }

    public int getRecogTypeNum() {
        return this.f9178b;
    }
}

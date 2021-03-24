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
    public String f9699a;

    /* renamed from: b  reason: collision with root package name */
    public int f9700b;

    PassFaceRecogType(String str, int i) {
        this.f9699a = str;
        this.f9700b = i;
    }

    public String getRecogTypeName() {
        return this.f9699a;
    }

    public int getRecogTypeNum() {
        return this.f9700b;
    }
}

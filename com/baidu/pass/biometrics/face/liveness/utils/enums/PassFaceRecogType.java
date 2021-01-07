package com.baidu.pass.biometrics.face.liveness.utils.enums;
/* loaded from: classes7.dex */
public enum PassFaceRecogType {
    RECOG_TYPE_BDUSS("recog_type_bduss", 1),
    RECOG_TYPE_AUTHTOKEN("recog_type_authtoken", 2),
    RECOG_TYPE_CERTINFO("recog_type_certinfo", 3),
    RECOG_TYPE_FACEDETECT("recog_type_facedetect", 4),
    RECOG_TYPE_OUTER("recog_type_outer", 5);
    

    /* renamed from: b  reason: collision with root package name */
    private String f4084b;
    private int c;

    PassFaceRecogType(String str, int i) {
        this.f4084b = str;
        this.c = i;
    }

    public String getRecogTypeName() {
        return this.f4084b;
    }

    public int getRecogTypeNum() {
        return this.c;
    }
}

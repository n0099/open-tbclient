package com.baidu.fsg.face.liveness.utils.enums;
/* loaded from: classes2.dex */
public enum LivenessRecogType {
    RECOG_TYPE_BDUSS("recog_type_bduss", 1),
    RECOG_TYPE_AUTHTOKEN("recog_type_authtoken", 2),
    RECOG_TYPE_CERTINFO("recog_type_certinfo", 3),
    RECOG_TYPE_FACEDETECT("recog_type_facedetect", 4),
    RECOG_TYPE_OUTER("recog_type_outer", 5);
    
    public String recogTypeName;
    public int recogTypeNum;

    LivenessRecogType(String str, int i2) {
        this.recogTypeName = str;
        this.recogTypeNum = i2;
    }

    public String getRecogTypeName() {
        return this.recogTypeName;
    }

    public int getRecogTypeNum() {
        return this.recogTypeNum;
    }
}

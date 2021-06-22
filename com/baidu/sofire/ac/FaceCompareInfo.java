package com.baidu.sofire.ac;

import android.text.TextUtils;
import com.baidu.sofire.ac.FaceEnum;
import com.baidu.sofire.utility.c;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class FaceCompareInfo implements IFaceProcessInfo {
    public int faceSortType;
    public FaceEnum.FaceType faceType;
    public FaceEnum.LivenessControl livenessControl;
    public String phoneNumber;
    public FaceEnum.QualityControl qualityControl;
    public FaceEnum.FaceType registerFaceType;
    public String registerImage;
    public FaceEnum.ImageType registerImageType;
    public FaceEnum.LivenessControl registerLivenessControl;
    public FaceEnum.QualityControl registerQualityControl;

    public FaceCompareInfo(FaceEnum.QualityControl qualityControl, FaceEnum.LivenessControl livenessControl, FaceEnum.FaceType faceType, int i2, String str, FaceEnum.ImageType imageType, FaceEnum.FaceType faceType2, FaceEnum.QualityControl qualityControl2, FaceEnum.LivenessControl livenessControl2, String str2) {
        this.qualityControl = qualityControl;
        this.livenessControl = livenessControl;
        this.faceType = faceType;
        this.faceSortType = i2;
        this.registerImage = str;
        this.registerImageType = imageType;
        this.registerFaceType = faceType2;
        this.registerQualityControl = qualityControl2;
        this.registerLivenessControl = livenessControl2;
        this.phoneNumber = str2;
    }

    @Override // com.baidu.sofire.ac.IFaceProcessInfo
    public JSONObject buildJson() {
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.qualityControl != null) {
                jSONObject.put("quality_control", this.qualityControl.name());
            }
            if (this.livenessControl != null) {
                jSONObject.put("liveness_control", this.livenessControl.name());
            }
            if (this.faceType != null) {
                jSONObject.put("face_type", this.faceType.name());
            }
            jSONObject.put("face_sort_type", this.faceSortType);
            if (!TextUtils.isEmpty(this.registerImage)) {
                jSONObject.put("register_image", this.registerImage);
            }
            if (this.registerImageType != null) {
                jSONObject.put("register_image_type", this.registerImageType.name());
            }
            if (this.registerFaceType != null) {
                jSONObject.put("register_face_type", this.registerFaceType.name());
            }
            if (this.registerQualityControl != null) {
                jSONObject.put("register_quality_control", this.registerQualityControl.name());
            }
            if (this.registerLivenessControl != null) {
                jSONObject.put("register_liveness_control", this.registerLivenessControl.name());
            }
            if (this.phoneNumber != null) {
                jSONObject.put("phone", this.phoneNumber);
            }
            return jSONObject;
        } catch (Throwable unused) {
            c.a();
            return null;
        }
    }
}

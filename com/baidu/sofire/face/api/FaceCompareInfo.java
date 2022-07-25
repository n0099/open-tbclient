package com.baidu.sofire.face.api;

import android.text.TextUtils;
import com.baidu.sofire.face.api.FaceEnum;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class FaceCompareInfo implements IFaceProcessInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
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

    public FaceCompareInfo(FaceEnum.QualityControl qualityControl, FaceEnum.LivenessControl livenessControl, FaceEnum.FaceType faceType, int i, String str, FaceEnum.ImageType imageType, FaceEnum.FaceType faceType2, FaceEnum.QualityControl qualityControl2, FaceEnum.LivenessControl livenessControl2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qualityControl, livenessControl, faceType, Integer.valueOf(i), str, imageType, faceType2, qualityControl2, livenessControl2, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.qualityControl = qualityControl;
        this.livenessControl = livenessControl;
        this.faceType = faceType;
        this.faceSortType = i;
        this.registerImage = str;
        this.registerImageType = imageType;
        this.registerFaceType = faceType2;
        this.registerQualityControl = qualityControl2;
        this.registerLivenessControl = livenessControl2;
        this.phoneNumber = str2;
    }

    @Override // com.baidu.sofire.face.api.IFaceProcessInfo
    public JSONObject buildJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                FaceEnum.QualityControl qualityControl = this.qualityControl;
                if (qualityControl != null) {
                    jSONObject.put("quality_control", qualityControl.name());
                }
                FaceEnum.LivenessControl livenessControl = this.livenessControl;
                if (livenessControl != null) {
                    jSONObject.put("liveness_control", livenessControl.name());
                }
                FaceEnum.FaceType faceType = this.faceType;
                if (faceType != null) {
                    jSONObject.put("face_type", faceType.name());
                }
                jSONObject.put("face_sort_type", this.faceSortType);
                if (!TextUtils.isEmpty(this.registerImage)) {
                    jSONObject.put("register_image", this.registerImage);
                }
                FaceEnum.ImageType imageType = this.registerImageType;
                if (imageType != null) {
                    jSONObject.put("register_image_type", imageType.name());
                }
                FaceEnum.FaceType faceType2 = this.registerFaceType;
                if (faceType2 != null) {
                    jSONObject.put("register_face_type", faceType2.name());
                }
                FaceEnum.QualityControl qualityControl2 = this.registerQualityControl;
                if (qualityControl2 != null) {
                    jSONObject.put("register_quality_control", qualityControl2.name());
                }
                FaceEnum.LivenessControl livenessControl2 = this.registerLivenessControl;
                if (livenessControl2 != null) {
                    jSONObject.put("register_liveness_control", livenessControl2.name());
                }
                String str = this.phoneNumber;
                if (str != null) {
                    jSONObject.put("phone", str);
                }
                return jSONObject;
            } catch (Throwable unused) {
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }
}

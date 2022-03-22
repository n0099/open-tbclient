package com.baidu.sofire.ac;

import android.text.TextUtils;
import com.baidu.sofire.ac.FaceEnum;
import com.baidu.sofire.utility.CommonMethods;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes4.dex */
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

    @Override // com.baidu.sofire.ac.IFaceProcessInfo
    public JSONObject buildJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
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
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }
}

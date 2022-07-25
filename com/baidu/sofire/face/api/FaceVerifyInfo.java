package com.baidu.sofire.face.api;

import android.text.TextUtils;
import com.baidu.sofire.face.api.FaceEnum;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URLEncoder;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class FaceVerifyInfo implements IFaceProcessInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String idCardNumber;
    public FaceEnum.LivenessControl livenessControl;
    public String name;
    public String nation;
    public String phoneNumber;
    public FaceEnum.QualityControl qualityControl;
    public FaceEnum.SpoofingControl spoofingControl;
    public int verifyType;

    public FaceVerifyInfo(String str, String str2, int i, String str3, FaceEnum.LivenessControl livenessControl, FaceEnum.SpoofingControl spoofingControl, FaceEnum.QualityControl qualityControl, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, Integer.valueOf(i), str3, livenessControl, spoofingControl, qualityControl, str4};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.idCardNumber = str;
        this.name = str2;
        this.verifyType = i;
        this.nation = str3;
        this.livenessControl = livenessControl;
        this.spoofingControl = spoofingControl;
        this.qualityControl = qualityControl;
        this.phoneNumber = str4;
    }

    @Override // com.baidu.sofire.face.api.IFaceProcessInfo
    public JSONObject buildJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                if (!TextUtils.isEmpty(this.idCardNumber)) {
                    jSONObject.put("id_card_number", this.idCardNumber);
                }
                if (!TextUtils.isEmpty(this.name)) {
                    jSONObject.put("name", URLEncoder.encode(this.name, "UTF-8"));
                }
                jSONObject.put("verify_type", String.valueOf(this.verifyType));
                String str = this.nation;
                if (str != null) {
                    jSONObject.put("nation", str);
                }
                FaceEnum.LivenessControl livenessControl = this.livenessControl;
                if (livenessControl != null) {
                    jSONObject.put("liveness_control", livenessControl.name());
                }
                FaceEnum.SpoofingControl spoofingControl = this.spoofingControl;
                if (spoofingControl != null) {
                    jSONObject.put("spoofing_control", spoofingControl.name());
                }
                FaceEnum.QualityControl qualityControl = this.qualityControl;
                if (qualityControl != null) {
                    jSONObject.put("quality_control", qualityControl.name());
                }
                String str2 = this.phoneNumber;
                if (str2 != null) {
                    jSONObject.put("phone", str2);
                }
                return jSONObject;
            } catch (Throwable unused) {
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }
}

package com.baidu.sofire.ac;

import android.text.TextUtils;
import com.baidu.sofire.ac.FaceEnum;
import com.baidu.sofire.utility.c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.iddetect.UrlOcrConfig;
import java.net.URLEncoder;
import org.json.JSONObject;
/* loaded from: classes10.dex */
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

    public FaceVerifyInfo(String str, String str2, int i2, String str3, FaceEnum.LivenessControl livenessControl, FaceEnum.SpoofingControl spoofingControl, FaceEnum.QualityControl qualityControl, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, Integer.valueOf(i2), str3, livenessControl, spoofingControl, qualityControl, str4};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.idCardNumber = str;
        this.name = str2;
        this.verifyType = i2;
        this.nation = str3;
        this.livenessControl = livenessControl;
        this.spoofingControl = spoofingControl;
        this.qualityControl = qualityControl;
        this.phoneNumber = str4;
    }

    @Override // com.baidu.sofire.ac.IFaceProcessInfo
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
                if (this.nation != null) {
                    jSONObject.put(UrlOcrConfig.IdCardKey.NATION, this.nation);
                }
                if (this.livenessControl != null) {
                    jSONObject.put("liveness_control", this.livenessControl.name());
                }
                if (this.spoofingControl != null) {
                    jSONObject.put("spoofing_control", this.spoofingControl.name());
                }
                if (this.qualityControl != null) {
                    jSONObject.put("quality_control", this.qualityControl.name());
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
        return (JSONObject) invokeV.objValue;
    }
}

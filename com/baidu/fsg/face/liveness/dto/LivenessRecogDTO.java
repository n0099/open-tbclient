package com.baidu.fsg.face.liveness.dto;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.base.restnet.beans.business.core.PayUtils;
import com.baidu.fsg.face.base.dto.SapiBiometricDto;
import com.baidu.fsg.face.liveness.beans.c;
import com.baidu.fsg.face.liveness.utils.enums.LivenessRecogType;
import com.baidu.pass.biometrics.face.liveness.dto.PassFaceRecogDTO;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class LivenessRecogDTO extends SapiBiometricDto {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int IMAGE_FLAG_CUTIMAGE = 1;
    public static final int IMAGE_FLAG_ORIGINIMAGE = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public String authToken;
    public String bduss;
    public String exUid;
    public String idCardNum;
    public String imageFlag;
    public String livenessServiceId;
    public LivenessRecogType livenessType;
    public String phoneNum;
    public String processid;
    public boolean randomLiveness;
    public String realName;
    public boolean recordAudio;
    public boolean recordLiveness;
    public String serviceType;
    public boolean showGuidePage;
    public boolean soundSwitch;
    public String spParams;
    public String stoken;
    public boolean switchVideo;
    public String uid;

    public LivenessRecogDTO() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.showGuidePage = true;
        this.soundSwitch = false;
        this.randomLiveness = false;
        this.recordLiveness = false;
        this.switchVideo = false;
        this.recordAudio = false;
        this.livenessType = LivenessRecogType.RECOG_TYPE_BDUSS;
        this.livenessServiceId = "1";
        this.imageFlag = "0";
    }

    private HashMap<String, String> getSPParamsHashmap() {
        InterceptResult invokeV;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            HashMap<String, String> hashMap = new HashMap<>();
            if (!TextUtils.isEmpty(this.spParams)) {
                try {
                    String[] split2 = this.spParams.split("&");
                    if (split2 != null && split2.length > 0) {
                        for (String str : split2) {
                            if (str != null && (split = str.split("=")) != null && split.length == 2) {
                                hashMap.put(split[0], split[1]);
                            }
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }

    private int returnImageFlag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            SapiBiometricDto a2 = c.a().a("request_data");
            if (a2 == null || !(a2 instanceof LivenessRecogDTO)) {
                return 0;
            }
            LivenessRecogDTO livenessRecogDTO = (LivenessRecogDTO) a2;
            if (TextUtils.isEmpty(livenessRecogDTO.imageFlag)) {
                return 0;
            }
            try {
                return Integer.parseInt(livenessRecogDTO.imageFlag);
            } catch (Exception e2) {
                e2.printStackTrace();
                return 0;
            }
        }
        return invokeV.intValue;
    }

    public String getAccessToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            HashMap<String, String> sPParamsHashmap = getSPParamsHashmap();
            return sPParamsHashmap != null ? sPParamsHashmap.get("access_token") : "";
        }
        return (String) invokeV.objValue;
    }

    public String getAtbc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (TextUtils.isEmpty(this.bduss)) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            sb.append("bduss=" + this.bduss);
            sb.append(";stoken=" + this.stoken);
            return PayUtils.encrypt("phone_number", sb.toString());
        }
        return (String) invokeV.objValue;
    }

    public String getCertInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (TextUtils.isEmpty(this.realName) || TextUtils.isEmpty(this.idCardNum)) {
                return "";
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("name", this.realName);
                jSONObject.put("cert", this.idCardNum);
                jSONObject.put("bankmobile", this.phoneNum);
                return PayUtils.encrypt("phone_number", jSONObject.toString());
            } catch (Exception e2) {
                e2.printStackTrace();
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public String getSpno() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            HashMap<String, String> sPParamsHashmap = getSPParamsHashmap();
            return sPParamsHashmap != null ? sPParamsHashmap.get(PassFaceRecogDTO.KEY_EXTRA_PASS_PRODUCT_ID) : "";
        }
        return (String) invokeV.objValue;
    }

    public boolean isReturnCutImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? (returnImageFlag() & 1) == 1 : invokeV.booleanValue;
    }

    public boolean isReturnOriginImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (returnImageFlag() & 2) == 2 : invokeV.booleanValue;
    }

    public boolean isVideoRecog() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? !TextUtils.isEmpty(this.livenessServiceId) && this.livenessServiceId.equals("2") : invokeV.booleanValue;
    }
}

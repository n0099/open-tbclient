package com.baidu.pass.biometrics.face.liveness.dto;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.biometrics.base.dto.PassBiometricDto;
import com.baidu.pass.biometrics.face.liveness.a.a;
import com.baidu.pass.biometrics.face.liveness.utils.enums.PassFaceRecogType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class PassFaceRecogDTO extends PassBiometricDto {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int IMAGE_FLAG_CUT_AND_ORIGIN_IMAGE = 3;
    public static final int IMAGE_FLAG_CUT_IMAGE = 1;
    public static final int IMAGE_FLAG_ORIGIN_IMAGE = 2;
    public static final int IMAGE_FLAG_WITHOUT_IMAGE = 0;
    public static final String KEY_EXTRA_ACCESS_TOKEN = "access_token";
    public static final String KEY_EXTRA_PASS_PRODUCT_ID = "sp_no";
    public transient /* synthetic */ FieldHolder $fh;
    public String authToken;
    public String bduss;
    public String di;
    public String exUid;
    public Bundle extraParams;
    public Map extraParamsMap;
    public int faceDebug;
    public String idCardNum;
    public String imageFlag;
    public PassFaceRecogType livenessType;
    public boolean needAuthorizeCertInfo;
    public String passProductId;
    public String phoneNum;
    public List poseList;
    public String processid;
    public int quality;
    public String realName;
    public String serviceType;
    public String stoken;
    public String uid;

    public PassFaceRecogDTO() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.livenessType = PassFaceRecogType.RECOG_TYPE_BDUSS;
        this.extraParamsMap = new HashMap();
        this.di = "";
        this.imageFlag = "0";
    }

    private int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            PassBiometricDto a = a.b().a(a.c);
            if (a instanceof PassFaceRecogDTO) {
                PassFaceRecogDTO passFaceRecogDTO = (PassFaceRecogDTO) a;
                if (!TextUtils.isEmpty(passFaceRecogDTO.imageFlag)) {
                    try {
                        return Integer.parseInt(passFaceRecogDTO.imageFlag);
                    } catch (Exception e) {
                        e.printStackTrace();
                        return 0;
                    }
                }
                return 0;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public String getAccessToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return (String) this.extraParamsMap.get("access_token");
        }
        return (String) invokeV.objValue;
    }

    public String getSpno() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return (String) this.extraParamsMap.get(KEY_EXTRA_PASS_PRODUCT_ID);
        }
        return (String) invokeV.objValue;
    }

    public boolean isReturnCutImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if ((a() & 1) == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isReturnOriginImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if ((a() & 2) == 2) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public String getSpParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry entry : this.extraParamsMap.entrySet()) {
                if (!TextUtils.isEmpty((CharSequence) entry.getKey()) && !TextUtils.isEmpty((CharSequence) entry.getValue())) {
                    if (TextUtils.isEmpty(sb.toString())) {
                        sb.append((String) entry.getKey());
                        sb.append("=");
                        sb.append((String) entry.getValue());
                    } else {
                        sb.append("&");
                        sb.append((String) entry.getKey());
                        sb.append("=");
                        sb.append((String) entry.getValue());
                    }
                }
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}

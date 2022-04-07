package com.baidu.pass.biometrics.base.http.result;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.biometrics.base.result.PassBiometricResult;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class ContrastPortraitResult extends PassBiometricResult {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ERROR_CODE_CONTRAST_FAIL = -302;
    public static final int ERROR_CODE_GET_USERINFO_FAILURE = 1;
    public static final int ERROR_CODE_IMAGE_FILE_EMPTY = -306;
    public static final int ERROR_CODE_UPLOAD_FAILURE = 2;
    public static final String ERROR_MSG_CONTRAST_FAIL = "人脸对比失败，请确保本人操作";
    public static final String ERROR_MSG_GET_USERINFO_FAILURE = "获取用户信息失败";
    public static final String ERROR_MSG_IMAGE_FILE_EMPTY = "获取人脸图像失败";
    public static final String ERROR_MSG_UPLOAD_FAILURE = "系统繁忙，请稍候重试";
    public transient /* synthetic */ FieldHolder $fh;
    public String authsid;
    public String callbackkey;
    public int contrastres;
    public int finalres;
    public int finish;
    public String imgdigests;
    public int recordvideo;

    public ContrastPortraitResult() {
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
        this.msgMap.put(1, ERROR_MSG_GET_USERINFO_FAILURE);
        this.msgMap.put(2, ERROR_MSG_UPLOAD_FAILURE);
        this.msgMap.put(-306, ERROR_MSG_IMAGE_FILE_EMPTY);
        this.msgMap.put(-302, ERROR_MSG_CONTRAST_FAIL);
    }

    public boolean isFinish() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.finish == 1 : invokeV.booleanValue;
    }

    public boolean isProcessPass() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? 1 == this.finalres : invokeV.booleanValue;
    }
}

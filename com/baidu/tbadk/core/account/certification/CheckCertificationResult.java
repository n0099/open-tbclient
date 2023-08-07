package com.baidu.tbadk.core.account.certification;

import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.baidu.sapi2.result.CheckUserFaceIdResult;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class CheckCertificationResult {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int PASS_AUTH_STATUS_JUNIOR = 1;
    public static final int PASS_AUTH_STATUS_NON = 0;
    public static final int PASS_AUTH_STATUS_SENIOR = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public String action;
    public String authWidgetURL;
    public String authsid;
    public int code;
    public String livingUname;
    public String resultMsg;
    @Keep
    public boolean sdkCallbackSuccess;
    public int status;

    public CheckCertificationResult() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public int getRealNameStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if ("advanced_cert_face_match".equals(this.action)) {
                return 2;
            }
            if ("cert_face_match".equals(this.action)) {
                return 1;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Nullable
    public static CheckCertificationResult parseFromSdk(CheckUserFaceIdResult checkUserFaceIdResult, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65537, null, checkUserFaceIdResult, z)) == null) {
            if (checkUserFaceIdResult == null) {
                return null;
            }
            CheckCertificationResult checkCertificationResult = new CheckCertificationResult();
            checkCertificationResult.sdkCallbackSuccess = z;
            checkCertificationResult.code = checkUserFaceIdResult.getResultCode();
            checkCertificationResult.action = checkUserFaceIdResult.action;
            checkCertificationResult.status = checkUserFaceIdResult.status;
            checkCertificationResult.resultMsg = checkUserFaceIdResult.getResultMsg();
            checkCertificationResult.livingUname = checkUserFaceIdResult.livingUname;
            checkCertificationResult.authsid = checkUserFaceIdResult.authsid;
            checkCertificationResult.authWidgetURL = checkUserFaceIdResult.authWidgetURL;
            return checkCertificationResult;
        }
        return (CheckCertificationResult) invokeLZ.objValue;
    }
}

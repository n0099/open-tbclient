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
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public String b;
    public int c;
    public String d;
    public String e;
    public String f;
    public String g;
    @Keep
    public boolean sdkCallbackSuccess;

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

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if ("advanced_cert_face_match".equals(this.b)) {
                return 2;
            }
            if ("cert_face_match".equals(this.b)) {
                return 1;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Nullable
    public static CheckCertificationResult b(CheckUserFaceIdResult checkUserFaceIdResult, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65537, null, checkUserFaceIdResult, z)) == null) {
            if (checkUserFaceIdResult == null) {
                return null;
            }
            CheckCertificationResult checkCertificationResult = new CheckCertificationResult();
            checkCertificationResult.sdkCallbackSuccess = z;
            checkCertificationResult.a = checkUserFaceIdResult.getResultCode();
            checkCertificationResult.b = checkUserFaceIdResult.action;
            checkCertificationResult.c = checkUserFaceIdResult.status;
            checkCertificationResult.d = checkUserFaceIdResult.getResultMsg();
            checkCertificationResult.e = checkUserFaceIdResult.livingUname;
            checkCertificationResult.f = checkUserFaceIdResult.authsid;
            checkCertificationResult.g = checkUserFaceIdResult.authWidgetURL;
            return checkCertificationResult;
        }
        return (CheckCertificationResult) invokeLZ.objValue;
    }
}

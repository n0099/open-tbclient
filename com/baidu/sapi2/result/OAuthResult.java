package com.baidu.sapi2.result;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class OAuthResult extends SapiResult {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ERROR_MSG_UNKNOWN = "授权失败";
    public static final String RESULT_MSG_SUCCESS = "授权成功";
    public transient /* synthetic */ FieldHolder $fh;
    public String accessToken;
    public int expiresIn;
    public String extra;
    public String openid;
    public String refreshToken;
    public String scope;
    public String sessionKey;
    public String sessionSecret;

    public OAuthResult() {
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
        this.msgMap.put(0, RESULT_MSG_SUCCESS);
        this.msgMap.put(-202, ERROR_MSG_UNKNOWN);
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "OAuthResult{accessToken='" + this.accessToken + "', expiresIn=" + this.expiresIn + ", refreshToken='" + this.refreshToken + "', scope='" + this.scope + "', sessionKey='" + this.sessionKey + "', sessionSecret='" + this.sessionSecret + "', extra='" + this.extra + "'}";
        }
        return (String) invokeV.objValue;
    }
}

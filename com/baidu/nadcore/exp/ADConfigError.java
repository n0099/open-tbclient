package com.baidu.nadcore.exp;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class ADConfigError extends Exception {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ERROR_NET_ERROR_RESPONSE_NULL = "1";
    public static final String ERROR_NULL_CODE = "4";
    public static final String ERROR_NULL_DATA = "7";
    public static final String ERROR_NULL_MSG = "6";
    public static final String ERROR_NULL_SIGN = "2";
    public static final String ERROR_OTHER = "10";
    public static final String ERROR_RESPONSE_CODE = "8";
    public static final String ERROR_WRONG_CODE = "3";
    public static final String ERROR_WRONG_MSG = "5";
    public static final String REASON_BUILD_REQUEST_FAILED = "failed to build request";
    public static final String REASON_NULL_CODE = "error_code is null";
    public static final String REASON_NULL_DATA = "data is null";
    public static final String REASON_NULL_MSG = "error_message is null";
    public static final String REASON_NULL_RESPONSE = "response is null";
    public static final String REASON_NULL_RESPONSE_BODY = "body of response is null";
    public static final String REASON_NULL_SIGN = "sign is null";
    public static final String REASON_REQUEST_SUCCESS = "request success";
    public static final String REASON_WRONG_CODE = "error_code is wrong";
    public static final String REASON_WRONG_MSG = "errorMsg is wrong";
    public static final String REQUEST_HAS_SUCCESS_BEFORE = "101";
    public static final String REQUEST_SUCCESS = "0";
    public transient /* synthetic */ FieldHolder $fh;
    public String code;
    public String reason;

    public ADConfigError(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.code = str;
        this.reason = str2;
    }

    public static ADConfigError error(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            return new ADConfigError(str, str2);
        }
        return (ADConfigError) invokeLL.objValue;
    }
}

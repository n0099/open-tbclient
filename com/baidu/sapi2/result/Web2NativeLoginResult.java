package com.baidu.sapi2.result;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class Web2NativeLoginResult extends SapiResult {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ERROR_CODE_BDUSS_EMPTY = -101;
    public static final String ERROR_MSG_BDUSS_EMPTY = "BDUSS EMPTY";
    public static final String ERROR_MSG_UNKNOWN = "登录失败";
    public static final int RESULT_CODE_BDUSS_EXPIRED = 400021;
    public static final String RESULT_MSG_BDUSS_EXPIRED = "用户登录状态失效，请重新登录";
    public transient /* synthetic */ FieldHolder $fh;

    public Web2NativeLoginResult() {
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
        this.msgMap.put(400021, "用户登录状态失效，请重新登录");
        this.msgMap.put(-101, ERROR_MSG_BDUSS_EMPTY);
        this.msgMap.put(-202, "登录失败");
    }
}

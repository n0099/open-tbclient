package com.baidu.pass.ecommerce.result;

import com.baidu.sapi2.result.SapiResult;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class GetContactResult extends SapiResult {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ERROR_CODE_NO_PERMISSION = -901;
    public static final String ERROR_MSG_NO_PERMISSION = "无权限";
    public transient /* synthetic */ FieldHolder $fh;
    public String name;
    public String phone;

    public GetContactResult() {
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
        this.msgMap.put(-901, ERROR_MSG_NO_PERMISSION);
    }
}

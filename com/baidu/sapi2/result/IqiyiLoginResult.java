package com.baidu.sapi2.result;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class IqiyiLoginResult extends SapiResult {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ERROR_CODE_ACCESSTOKEN_NULL_FAILURE = -101;
    public static final String ERROR_MSG_ACCESSTOKEN_NULL_FAILURE = "无权限（accesstoken == null)";
    public transient /* synthetic */ FieldHolder $fh;
    public String nextUrl;

    public IqiyiLoginResult() {
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
        this.msgMap.put(-101, ERROR_MSG_ACCESSTOKEN_NULL_FAILURE);
    }
}

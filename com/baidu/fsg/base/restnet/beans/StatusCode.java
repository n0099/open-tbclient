package com.baidu.fsg.base.restnet.beans;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public abstract class StatusCode {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CLIENT_SIGN_CHECK_ERROR = -1;
    public static final int ERROR_HTTP_CLIENT = -2;
    public static final int ERROR_HTTP_SERVER = -3;
    public static final int ERROR_INVALIDATE_SPNO = -32;
    public static final int ERROR_INVLID_RESPONSE = -4;
    public static final int ERROR_NOT_LOGIN = 5003;
    public static final int ERROR_NO_NETWORK = -8;
    public static final int ERROR_PASSWORD = -7;
    public static final int ERROR_REST_FRAMEWORK_EXCEPTION = -15;
    public static final int ERROR_REST_FRAMEWORK_SSL = -16;
    public static final int ERROR_REST_FRAMEWORK_TIMEOUNT = -5;
    public static final int RET_OK = 0;
    public transient /* synthetic */ FieldHolder $fh;

    public StatusCode() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}

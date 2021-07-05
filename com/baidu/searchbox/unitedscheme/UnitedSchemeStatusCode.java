package com.baidu.searchbox.unitedscheme;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class UnitedSchemeStatusCode {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ERR_ACL_CHECK_FAIL = 402;
    public static final int ERR_ACTION_NOT_FOUND = 302;
    public static final int ERR_EXECUTE_FAIL = 1001;
    public static final int ERR_EXE_ALLOW_FAIL = 403;
    public static final int ERR_MODULE_NOT_FOUND = 301;
    public static final int ERR_NOT_SUPPORT = 101;
    public static final int ERR_OK = 0;
    public static final int ERR_OPEN_APP_FAIL = 1002;
    public static final int ERR_PARAMS_PARSE_FAIL = 202;
    public static final int ERR_PARSE_FAIL = 201;
    public static final int ERR_SECURITY_CHECK_FAIL = 401;
    public static final String KEY_DATA = "data";
    public static final String KEY_MESSAGE = "message";
    public static final String KEY_STATUS = "status";
    public transient /* synthetic */ FieldHolder $fh;

    public UnitedSchemeStatusCode() {
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

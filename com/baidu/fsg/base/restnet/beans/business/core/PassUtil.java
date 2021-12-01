package com.baidu.fsg.base.restnet.beans.business.core;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public final class PassUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String NORMALIZE_URL = "normalize_url";
    public static final String PASS_ACCOUNT = "pass_account";
    public static final String PASS_ACCOUNT_TYPE = "pass_account_type";
    public static final String PASS_AUTH_SID = "pass_auth_sid";
    public static final String PASS_BDUSS = "pass_bduss";
    public static final String PASS_DISPLAY_NAME = "pass_display_name";
    public static final String PASS_ERROR_CODE = "pass_error_code";
    public static final String PASS_ERROR_MSG = "pass_error_msg";
    public static final String PASS_NEW_REQ = "pass_new_req";
    public static final String PASS_PASSWORD = "pass_code";
    public static final String PASS_PTOKEN = "pass_ptoken";
    public static final String PASS_SID = "pass_sid";
    public static final String PASS_STOKEN = "pass_stoken";
    public static final String PASS_TYPE = "pass_util_type";
    public static final String PASS_UBI = "pass_ubi";
    public static final String PASS_UID = "pass_uid";
    public static final String PASS_USER_NAEME = "pass_user_name";
    public static final int TYPE_COMPLETED = 1;
    public static final int TYPE_VERIFY = 2;
    public static long mCreateTime;
    public static Object object;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1755657914, "Lcom/baidu/fsg/base/restnet/beans/business/core/PassUtil;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1755657914, "Lcom/baidu/fsg/base/restnet/beans/business/core/PassUtil;");
                return;
            }
        }
        object = new Object();
    }

    public PassUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }
}

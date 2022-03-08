package com.baidu.sapi2.result;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class AccountCenterResult extends SapiResult {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ERROR_CODE_HANDLE_LOGIN = -10001;
    public static final int ERROR_CODE_LOGIN_SUCCESS = -10002;
    public static final String ERROR_MSG_HANDLE_LOGIN = "请登录";
    public static final String ERROR_MSG_LOGIN_SUCCESS = "获取登录态成功";
    public transient /* synthetic */ FieldHolder $fh;
    public String encryptedId;
    public boolean isAccountDestory;
    public boolean isAccountFreeze;
    public String preSetUserName;

    public AccountCenterResult() {
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
        this.isAccountDestory = false;
        this.isAccountFreeze = false;
        this.msgMap.put(-10001, "请登录");
        this.msgMap.put(-10002, ERROR_MSG_LOGIN_SUCCESS);
    }

    public void loginSuc() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }
}

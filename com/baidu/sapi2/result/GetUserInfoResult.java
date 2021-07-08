package com.baidu.sapi2.result;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class GetUserInfoResult extends SapiResult {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ERROR_MSG_UNKNOWN = "用户信息获取失败";
    public static final int RESULT_CODE_BDUSS_EXPIRED = 400021;
    public static final String RESULT_MSG_BDUSS_EXPIRED = "用户登录状态失效，请重新登录";
    public transient /* synthetic */ FieldHolder $fh;
    public int carSdkFace;
    public String displayname;
    public int faceLoginSwitch;
    public boolean havePwd;
    public boolean incompleteUser;
    public boolean isInitialPortrait;
    public String portrait;
    public String portraitHttps;
    public String portraitSign;
    public String secureEmail;
    public String secureMobile;
    public String uid;
    public String username;

    public GetUserInfoResult() {
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
        this.isInitialPortrait = false;
        this.havePwd = true;
        this.msgMap.put(400021, "用户登录状态失效，请重新登录");
        this.msgMap.put(-202, ERROR_MSG_UNKNOWN);
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "GetUserInfoResult{username='" + this.username + "', displayname='" + this.displayname + "', uid='" + this.uid + "', secureMobile='" + this.secureMobile + "', secureEmail='" + this.secureEmail + "', incompleteUser=" + this.incompleteUser + ", portrait='" + this.portrait + "', portraitSign='" + this.portraitSign + "', isInitialPortrait=" + this.isInitialPortrait + ", havePwd=" + this.havePwd + '}';
        }
        return (String) invokeV.objValue;
    }
}

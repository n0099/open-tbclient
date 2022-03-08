package com.baidu.searchbox.account.contants;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class LoginConstants {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BOX_CHINA_MOBILE_OAUTH = 9;
    public static final int BOX_FACE_LOGIN = 8;
    public static final int BOX_FAST_LOGIN = 5;
    public static final int BOX_QQ_SSO_LOGIN = 3;
    public static final int BOX_SHARE_LOGIN = 7;
    public static final int BOX_SMSONLY_LOGIN = 6;
    public static final int BOX_SMS_LOGIN = 1;
    public static final int BOX_USERNAME_PASSWORD_LOGIN = 0;
    public static final int BOX_WECHAT_LOGIN = 2;
    public static final int BOX_WEIBO_LOGIN = 4;
    public static final String BUSINESS_BAIDU_MINI_PROGRAMS_SENCE = "baidu_mini_programs";
    public static final String FAST_LOGIN = "fast";
    public static final String QQ_LOGIN = "qq";
    public static final String SINA_LOGIN = "sina";
    public static final String SMSONLY_LOGIN = "smsOnly";
    public static final String SMS_LOGIN = "sms";
    public static final String USERNAME_LOGIN = "username";
    public static final String WECHAT_LOGIN = "wechat";
    public transient /* synthetic */ FieldHolder $fh;

    public LoginConstants() {
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

package com.baidu.sapi2.service;

import android.app.Activity;
import android.content.Context;
import com.baidu.sapi2.shell.listener.ThirdLoginCallback;
import com.baidu.sapi2.utils.enums.SocialType;
/* loaded from: classes5.dex */
public interface AbstractThirdPartyService {
    public static final String EXTRA_RESULT_CODE = "result_code";
    public static final String EXTRA_RESULT_MSG = "result_msg";
    public static final int REQUEST_SOCIAL_LOGIN = 2001;
    public static final int RESULT_AUTH_CANCEL = -1000;
    public static final String RESULT_AUTH_CANCEL_MSG = "取消授权登录";
    public static final int RESULT_AUTH_FAILURE = 1002;
    public static final int RESULT_AUTH_SUCCESS = 1001;
    public static final int RESULT_AUTH_UNSUPPORT = -10;
    public static final String RESULT_AUTH_UNSUPPORT_MSG = "不支持YY授权登录";
    public static final int RESULT_UNKNOW_ERROR = -1;
    public static final String RESULT_UNKNOW_ERROR_MSG = "未知错误";

    void handleWXLoginResp(Activity activity, String str, String str2, int i2);

    void loadQQLogin(Context context, int i2);

    void loadThirdPartyLogin(Context context, SocialType socialType, int i2);

    void loadThirdPartyLogin(Context context, SocialType socialType, int i2, ThirdLoginCallback thirdLoginCallback);

    void loadThirdPartyLogin(Context context, SocialType socialType, int i2, String str);

    void loadThirdPartyLogin(Context context, SocialType socialType, int i2, String str, boolean z);

    void loadWechatLogin(Context context, int i2);

    void loadYYSSOLogin(Context context, String str);

    void socialBind(Activity activity, SocialType socialType, int i2, String str);
}

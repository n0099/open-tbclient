package com.baidu.sapi2.service;

import android.app.Activity;
import android.content.Context;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.utils.enums.SocialType;
/* loaded from: classes2.dex */
public interface AbstractThirdPartyService {
    public static final String EXTRA_RESULT_CODE = "result_code";
    public static final String EXTRA_RESULT_MSG = "result_msg";
    public static final int REQUEST_SOCIAL_LOGIN = 2001;
    public static final int RESULT_AUTH_FAILURE = 1002;
    public static final int RESULT_AUTH_SUCCESS = 1001;

    void loadHuaweiLogin(Context context, WebAuthListener webAuthListener, String str, String str2);

    void loadThirdPartyIndirect(Activity activity, int i, int i2);

    void loadThirdPartyLogin(Context context, WebAuthListener webAuthListener, SocialType socialType);
}

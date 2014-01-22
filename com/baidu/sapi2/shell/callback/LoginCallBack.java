package com.baidu.sapi2.shell.callback;

import com.baidu.sapi2.shell.response.LoginResponse;
/* loaded from: classes.dex */
public abstract class LoginCallBack implements SapiCallBack<LoginResponse> {
    public abstract void onCannotLogin();

    public abstract void onPasswordWrong();
}

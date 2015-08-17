package com.baidu.sapi2.callback;

import com.baidu.sapi2.result.LoginResult;
/* loaded from: classes.dex */
public abstract class LoginCallback implements CaptchaAware<LoginResult> {
    public abstract void onLoginTypeConflict(LoginResult loginResult);

    public abstract void onProxyActionRequired(LoginResult loginResult);
}

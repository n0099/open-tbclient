package com.baidu.sapi2.shell.listener;
/* loaded from: classes.dex */
public abstract class AuthorizationListener {
    public abstract void onFailed(int i, String str);

    public abstract void onSuccess();

    public boolean onForgetPwd() {
        return false;
    }
}

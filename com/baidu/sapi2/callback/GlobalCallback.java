package com.baidu.sapi2.callback;

import com.baidu.sapi2.SapiAccount;
/* loaded from: classes2.dex */
public abstract class GlobalCallback {
    public abstract void onLoginStatusChange();

    public void onLogoutSuccess(SapiAccount sapiAccount) {
    }

    public abstract void onNeedInitPassSdk();
}

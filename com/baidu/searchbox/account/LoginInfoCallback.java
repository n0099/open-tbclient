package com.baidu.searchbox.account;

import com.baidu.searchbox.account.result.LoginResult;
/* loaded from: classes3.dex */
public abstract class LoginInfoCallback {
    public volatile boolean isCallBacked;
    public volatile String loginSource;
    public volatile String loginStyleFrom;

    public abstract void onResult(LoginResult loginResult);

    public String getErrorFrom() {
        return this.loginStyleFrom;
    }

    public String getSource() {
        return this.loginSource;
    }

    public boolean isCallBacked() {
        return this.isCallBacked;
    }

    public void setCallBacked(boolean z) {
        this.isCallBacked = z;
    }

    public void setErrorFrom(String str) {
        this.loginStyleFrom = str;
    }

    public void setSource(String str) {
        this.loginSource = str;
    }
}

package com.baidu.livesdk.api.account;
/* loaded from: classes2.dex */
public interface Account {
    AccountBean accountInfo();

    void clearAccountChangeListener();

    boolean isLogin();

    void login();

    void setAccountChangeListener(AccountStatusChangedListener accountStatusChangedListener);
}

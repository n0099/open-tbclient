package com.baidu.sapi2.callback;

import com.baidu.sapi2.result.AccountCenterResult;
/* loaded from: classes2.dex */
public abstract class AccountCenterCallback {
    public abstract void onFinish(AccountCenterResult accountCenterResult);

    public abstract void onSocialBind(String str);

    public void onBdussChange() {
    }
}

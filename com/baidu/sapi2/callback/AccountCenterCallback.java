package com.baidu.sapi2.callback;

import android.content.Context;
import com.baidu.sapi2.result.AccountCenterResult;
/* loaded from: classes2.dex */
public abstract class AccountCenterCallback {
    public static final int REQUEST_CODE_LOGIN = 100001;

    public abstract void onFinish(AccountCenterResult accountCenterResult);

    public abstract void onSocialBind(String str);

    public void onLogin(Context context, int i, String str) {
    }

    public void onBdussChange() {
    }
}

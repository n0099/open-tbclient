package com.baidu.sapi2.shell.callback;

import com.baidu.sapi2.shell.response.SapiAccountResponse;
/* loaded from: classes.dex */
public abstract class FillUserProfileCallBack implements SapiCallBack<SapiAccountResponse> {
    public abstract void onBdussInvalid();

    public abstract void onFinish();

    public abstract void onPhoneUnavailable();

    public abstract void onSimUnavailable();

    public abstract void onUserNormalized();
}

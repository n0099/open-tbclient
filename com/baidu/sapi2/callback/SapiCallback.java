package com.baidu.sapi2.callback;

import com.baidu.sapi2.result.SapiResult;
/* loaded from: classes2.dex */
public interface SapiCallback {
    void onFailure(SapiResult sapiResult);

    void onFinish();

    void onStart();

    void onSuccess(SapiResult sapiResult);
}

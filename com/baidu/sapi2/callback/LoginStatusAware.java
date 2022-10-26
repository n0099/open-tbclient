package com.baidu.sapi2.callback;

import com.baidu.sapi2.result.SapiResult;
/* loaded from: classes2.dex */
public interface LoginStatusAware extends SapiCallback {
    void onBdussExpired(SapiResult sapiResult);
}

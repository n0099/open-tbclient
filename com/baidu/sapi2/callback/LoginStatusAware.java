package com.baidu.sapi2.callback;

import com.baidu.sapi2.result.SapiResult;
/* loaded from: classes9.dex */
public interface LoginStatusAware<R extends SapiResult> extends SapiCallback<R> {
    void onBdussExpired(R r);
}

package com.baidu.sapi2.callback;

import com.baidu.sapi2.result.SapiResult;
/* loaded from: classes9.dex */
public interface SapiCallbackInterceptor<R extends SapiResult> extends SapiCallback<R> {
    void beforeSuccess(R r);
}

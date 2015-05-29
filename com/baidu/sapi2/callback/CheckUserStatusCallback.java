package com.baidu.sapi2.callback;

import com.baidu.sapi2.result.SapiResult;
/* loaded from: classes.dex */
public interface CheckUserStatusCallback<R extends SapiResult> extends SapiCallback<R> {
    void onBdussExpired(R r);
}

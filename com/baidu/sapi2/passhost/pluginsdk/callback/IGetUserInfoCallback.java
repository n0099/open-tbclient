package com.baidu.sapi2.passhost.pluginsdk.callback;

import com.baidu.sapi2.passhost.pluginsdk.result.IGetUserInfoResult;
/* loaded from: classes.dex */
public interface IGetUserInfoCallback<R extends IGetUserInfoResult> {
    void onBdussExpired(IGetUserInfoResult iGetUserInfoResult);

    void onFailure(IGetUserInfoResult iGetUserInfoResult);

    void onFinish();

    void onStart();

    void onSuccess(IGetUserInfoResult iGetUserInfoResult);
}

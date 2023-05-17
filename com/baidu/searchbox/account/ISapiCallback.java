package com.baidu.searchbox.account;

import com.baidu.searchbox.account.result.BoxSapiResult;
/* loaded from: classes3.dex */
public interface ISapiCallback<R extends BoxSapiResult> {
    void onFailure(R r);

    void onFinish();

    void onStart();

    void onSuccess(R r);
}

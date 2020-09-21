package com.baidu.sapi2.shell.callback;

import com.baidu.sapi2.shell.response.SapiResponse;
/* loaded from: classes25.dex */
public interface SapiCallBack<R extends SapiResponse> {
    void onNetworkFailed();

    void onSuccess(R r);

    void onSystemError(int i);
}

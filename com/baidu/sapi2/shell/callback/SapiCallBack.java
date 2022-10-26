package com.baidu.sapi2.shell.callback;

import com.baidu.sapi2.shell.response.SapiResponse;
/* loaded from: classes2.dex */
public interface SapiCallBack {
    void onNetworkFailed();

    void onSuccess(SapiResponse sapiResponse);

    void onSystemError(int i);
}

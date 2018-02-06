package com.baidu.sapi2.shell.listener;

import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.callback.SapiCallback;
import com.baidu.sapi2.shell.result.WebAuthResult;
/* loaded from: classes2.dex */
public abstract class WebAuthListener implements SapiCallback<WebAuthResult> {
    public abstract void beforeSuccess(SapiAccount sapiAccount);

    @Override // com.baidu.sapi2.callback.SapiCallback
    public void onStart() {
    }

    @Override // com.baidu.sapi2.callback.SapiCallback
    public void onFinish() {
    }
}

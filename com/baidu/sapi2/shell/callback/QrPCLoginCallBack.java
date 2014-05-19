package com.baidu.sapi2.shell.callback;

import com.baidu.sapi2.shell.response.QrPCLoginResponse;
/* loaded from: classes.dex */
public abstract class QrPCLoginCallBack implements SapiCallBack<QrPCLoginResponse> {
    public abstract void onBdussInvalid();

    public abstract void onQrCodeInvalid();

    public abstract void onUserNotNormalized();

    public void onFinish() {
    }

    @Override // com.baidu.sapi2.shell.callback.SapiCallBack
    public void onNetworkFailed() {
    }
}

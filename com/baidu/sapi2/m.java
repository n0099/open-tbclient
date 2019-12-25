package com.baidu.sapi2;

import com.baidu.pass.biometrics.face.liveness.callback.PassFaceRecogCallback;
import com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult;
import com.baidu.sapi2.callback.ExtendSysWebViewMethodCallback;
import com.baidu.sapi2.result.ExtendSysWebViewMethodResult;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class m extends PassFaceRecogCallback {
    final /* synthetic */ ExtendSysWebViewMethodResult a;
    final /* synthetic */ ExtendSysWebViewMethodCallback b;
    final /* synthetic */ PassportSDK c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(PassportSDK passportSDK, ExtendSysWebViewMethodResult extendSysWebViewMethodResult, ExtendSysWebViewMethodCallback extendSysWebViewMethodCallback) {
        this.c = passportSDK;
        this.a = extendSysWebViewMethodResult;
        this.b = extendSysWebViewMethodCallback;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
    /* renamed from: a */
    public void onFailure(PassFaceRecogResult passFaceRecogResult) {
        ExtendSysWebViewMethodResult extendSysWebViewMethodResult = this.a;
        extendSysWebViewMethodResult.recogResult = passFaceRecogResult;
        this.b.onFinish(extendSysWebViewMethodResult);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
    /* renamed from: b */
    public void onSuccess(PassFaceRecogResult passFaceRecogResult) {
        ExtendSysWebViewMethodResult extendSysWebViewMethodResult = this.a;
        extendSysWebViewMethodResult.recogResult = passFaceRecogResult;
        this.b.onFinish(extendSysWebViewMethodResult);
    }
}

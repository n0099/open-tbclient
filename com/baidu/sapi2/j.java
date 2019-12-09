package com.baidu.sapi2;

import com.baidu.pass.biometrics.face.liveness.callback.PassFaceRecogCallback;
import com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult;
import com.baidu.sapi2.callback.VerifyUserFaceIDCallback;
import com.baidu.sapi2.result.RealNameFaceIDResult;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class j extends PassFaceRecogCallback {
    final /* synthetic */ RealNameFaceIDResult a;
    final /* synthetic */ VerifyUserFaceIDCallback b;
    final /* synthetic */ PassportSDK c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(PassportSDK passportSDK, RealNameFaceIDResult realNameFaceIDResult, VerifyUserFaceIDCallback verifyUserFaceIDCallback) {
        this.c = passportSDK;
        this.a = realNameFaceIDResult;
        this.b = verifyUserFaceIDCallback;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
    /* renamed from: a */
    public void onFailure(PassFaceRecogResult passFaceRecogResult) {
        this.a.setResultCode(passFaceRecogResult.getResultCode());
        this.a.setResultMsg(passFaceRecogResult.getResultMsg());
        this.b.onFailure(this.a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
    /* renamed from: b */
    public void onSuccess(PassFaceRecogResult passFaceRecogResult) {
        this.a.setResultCode(passFaceRecogResult.getResultCode());
        this.a.setResultMsg(passFaceRecogResult.getResultMsg());
        RealNameFaceIDResult realNameFaceIDResult = this.a;
        realNameFaceIDResult.authSid = passFaceRecogResult.authSid;
        realNameFaceIDResult.callBackKey = passFaceRecogResult.callbackkey;
        realNameFaceIDResult.setResultCode(0);
        this.b.onSuccess(this.a);
    }
}

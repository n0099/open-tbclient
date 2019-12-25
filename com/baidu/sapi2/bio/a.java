package com.baidu.sapi2.bio;

import com.baidu.pass.biometrics.face.liveness.callback.PassFaceRecogCallback;
import com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult;
import com.baidu.sapi2.utils.Log;
/* loaded from: classes4.dex */
class a extends PassFaceRecogCallback {
    final /* synthetic */ PassFaceRecogCallback a;
    final /* synthetic */ BiometricsManager b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BiometricsManager biometricsManager, PassFaceRecogCallback passFaceRecogCallback) {
        this.b = biometricsManager;
        this.a = passFaceRecogCallback;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
    /* renamed from: a */
    public void onFailure(PassFaceRecogResult passFaceRecogResult) {
        this.a.onFailure(passFaceRecogResult);
        Log.d(BiometricsManager.TAG, "result", passFaceRecogResult.toJSONObject());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
    /* renamed from: b */
    public void onSuccess(PassFaceRecogResult passFaceRecogResult) {
        this.a.onSuccess(passFaceRecogResult);
        Log.e(BiometricsManager.TAG, "result", passFaceRecogResult.toJSONObject(), "callbackkey", passFaceRecogResult.callbackkey);
        Log.d(BiometricsManager.TAG, "faceimage", passFaceRecogResult.faceimage, "imgdigests", passFaceRecogResult.imgdigests, "originalImage", passFaceRecogResult.originalImage);
    }
}

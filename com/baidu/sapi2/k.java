package com.baidu.sapi2;

import android.text.TextUtils;
import com.baidu.pass.biometrics.face.liveness.callback.PassFaceRecogCallback;
import com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult;
import com.baidu.sapi2.callback.FaceIDCallback;
import com.baidu.sapi2.result.UnRealNameFaceIDResult;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class k extends PassFaceRecogCallback {
    final /* synthetic */ UnRealNameFaceIDResult a;
    final /* synthetic */ String b;
    final /* synthetic */ FaceIDCallback c;
    final /* synthetic */ PassportSDK d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(PassportSDK passportSDK, UnRealNameFaceIDResult unRealNameFaceIDResult, String str, FaceIDCallback faceIDCallback) {
        this.d = passportSDK;
        this.a = unRealNameFaceIDResult;
        this.b = str;
        this.c = faceIDCallback;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
    /* renamed from: a */
    public void onFailure(PassFaceRecogResult passFaceRecogResult) {
        this.a.setResultCode(passFaceRecogResult.getResultCode());
        this.c.onFailure(this.a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
    /* renamed from: b */
    public void onSuccess(PassFaceRecogResult passFaceRecogResult) {
        JSONObject jSONObject;
        this.a.setResultMsg(passFaceRecogResult.getResultMsg());
        if (this.b.equals("faceDetect") && (jSONObject = passFaceRecogResult.extraJson) != null) {
            this.a.registerResult = jSONObject.toString();
        }
        UnRealNameFaceIDResult unRealNameFaceIDResult = this.a;
        unRealNameFaceIDResult.callBackKey = passFaceRecogResult.callbackkey;
        if (TextUtils.isEmpty(unRealNameFaceIDResult.callBackKey)) {
            this.a.setResultCode(-205);
            this.c.onFailure(this.a);
            return;
        }
        this.a.setResultCode(0);
        this.c.onSuccess(this.a);
    }
}

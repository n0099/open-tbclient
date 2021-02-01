package com.baidu.pass.biometrics.face.liveness.activity;

import android.os.Looper;
import android.text.TextUtils;
import com.baidu.pass.biometrics.base.debug.Log;
import com.baidu.pass.biometrics.base.http.HttpHandlerWrap;
import com.baidu.pass.biometrics.base.result.PassBiometricResult;
import com.baidu.pass.biometrics.face.liveness.callback.PassFaceRecogCallback;
import com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class i extends HttpHandlerWrap {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LivenessRecogActivity f4020a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(LivenessRecogActivity livenessRecogActivity, Looper looper) {
        super(looper);
        this.f4020a = livenessRecogActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.pass.biometrics.base.http.HttpHandlerWrap
    public void onFailure(Throwable th, int i, String str) {
        this.f4020a.a(-206, PassBiometricResult.ERROR_MSG_SERVER_ERROR);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.pass.biometrics.base.http.HttpHandlerWrap
    public void onSuccess(int i, String str) {
        PassFaceRecogCallback passFaceRecogCallback;
        Log.i("LivenessRecog", "faceDetectHttp|responseBody|" + str);
        PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
        try {
            passFaceRecogResult.extraJson = new JSONObject(str).getJSONObject("result");
            passFaceRecogResult.callbackkey = passFaceRecogResult.extraJson.optString("faceid");
            if (!TextUtils.isEmpty(passFaceRecogResult.callbackkey)) {
                passFaceRecogCallback = this.f4020a.t;
                if (passFaceRecogCallback != null) {
                    new h(this, passFaceRecogResult).execute(new Void[0]);
                    return;
                }
                return;
            }
            this.f4020a.a(-206, PassBiometricResult.ERROR_MSG_SERVER_ERROR);
        } catch (JSONException e) {
            this.f4020a.a(-206, PassBiometricResult.ERROR_MSG_SERVER_ERROR);
        }
    }
}

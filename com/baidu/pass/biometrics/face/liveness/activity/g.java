package com.baidu.pass.biometrics.face.liveness.activity;

import android.os.Looper;
import com.baidu.fsg.base.BaiduRimConstants;
import com.baidu.pass.biometrics.base.debug.Log;
import com.baidu.pass.biometrics.base.http.HttpHandlerWrap;
import com.baidu.pass.biometrics.base.http.result.ContrastPortraitResult;
import com.baidu.pass.biometrics.face.liveness.utils.enums.PassFaceRecogType;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class g extends HttpHandlerWrap {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ContrastPortraitResult f4050a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ LivenessRecogActivity f4051b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(LivenessRecogActivity livenessRecogActivity, Looper looper, ContrastPortraitResult contrastPortraitResult) {
        super(looper);
        this.f4051b = livenessRecogActivity;
        this.f4050a = contrastPortraitResult;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.pass.biometrics.base.http.HttpHandlerWrap
    public void onFailure(Throwable th, int i, String str) {
        this.f4050a.setResultCode(-206);
        this.f4050a.setResultMsg(ContrastPortraitResult.ERROR_MSG_SERVER_ERROR);
        this.f4051b.b(this.f4050a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.pass.biometrics.base.http.HttpHandlerWrap
    public void onSuccess(int i, String str) {
        try {
            Object[] objArr = new Object[1];
            objArr[0] = "portraitContrast|responseBody|" + str;
            Log.i("LivenessRecog", objArr);
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt(BaiduRimConstants.RETCODE_KEY);
            String optString = jSONObject.optString("retMsg");
            this.f4050a.setResultCode(optInt);
            this.f4050a.setResultMsg(optString);
            if (this.f4050a.getResultCode() == 0) {
                JSONObject optJSONObject = new JSONObject(str).optJSONObject("result");
                if (this.f4051b.passFaceRecogDTO.livenessType == PassFaceRecogType.RECOG_TYPE_AUTHTOKEN) {
                    this.f4050a.authsid = optJSONObject.optString("authsid");
                }
                this.f4050a.callbackkey = optJSONObject.optString("callbackkey");
                this.f4050a.contrastres = optJSONObject.optInt("contrastres");
                this.f4050a.finalres = optJSONObject.optInt("finalres");
                this.f4050a.finish = optJSONObject.optInt("finish");
                this.f4050a.imgdigests = optJSONObject.optString("imgdigests");
                this.f4050a.recordvideo = optJSONObject.optInt("recordvideo");
            }
        } catch (JSONException e) {
            Log.e(e);
            this.f4050a.setResultCode(-206);
            this.f4050a.setResultMsg(ContrastPortraitResult.ERROR_MSG_SERVER_ERROR);
        }
        this.f4051b.c(this.f4050a);
    }
}

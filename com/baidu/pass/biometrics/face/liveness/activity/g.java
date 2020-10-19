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
/* loaded from: classes18.dex */
public class g extends HttpHandlerWrap {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ContrastPortraitResult f2734a;
    final /* synthetic */ LivenessRecogActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(LivenessRecogActivity livenessRecogActivity, Looper looper, ContrastPortraitResult contrastPortraitResult) {
        super(looper);
        this.b = livenessRecogActivity;
        this.f2734a = contrastPortraitResult;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.pass.biometrics.base.http.HttpHandlerWrap
    public void onFailure(Throwable th, int i, String str) {
        this.f2734a.setResultCode(-206);
        this.f2734a.setResultMsg(ContrastPortraitResult.ERROR_MSG_SERVER_ERROR);
        this.b.b(this.f2734a);
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
            this.f2734a.setResultCode(optInt);
            this.f2734a.setResultMsg(optString);
            if (this.f2734a.getResultCode() == 0) {
                JSONObject optJSONObject = new JSONObject(str).optJSONObject("result");
                if (this.b.passFaceRecogDTO.livenessType == PassFaceRecogType.RECOG_TYPE_AUTHTOKEN) {
                    this.f2734a.authsid = optJSONObject.optString("authsid");
                }
                this.f2734a.callbackkey = optJSONObject.optString("callbackkey");
                this.f2734a.contrastres = optJSONObject.optInt("contrastres");
                this.f2734a.finalres = optJSONObject.optInt("finalres");
                this.f2734a.finish = optJSONObject.optInt("finish");
                this.f2734a.imgdigests = optJSONObject.optString("imgdigests");
                this.f2734a.recordvideo = optJSONObject.optInt("recordvideo");
            }
        } catch (JSONException e) {
            Log.e(e);
            this.f2734a.setResultCode(-206);
            this.f2734a.setResultMsg(ContrastPortraitResult.ERROR_MSG_SERVER_ERROR);
        }
        this.b.c(this.f2734a);
    }
}

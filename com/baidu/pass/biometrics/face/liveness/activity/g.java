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
/* loaded from: classes8.dex */
public class g extends HttpHandlerWrap {
    final /* synthetic */ ContrastPortraitResult a;
    final /* synthetic */ LivenessRecogActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(LivenessRecogActivity livenessRecogActivity, Looper looper, ContrastPortraitResult contrastPortraitResult) {
        super(looper);
        this.b = livenessRecogActivity;
        this.a = contrastPortraitResult;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.pass.biometrics.base.http.HttpHandlerWrap
    public void onFailure(Throwable th, int i, String str) {
        this.a.setResultCode(-206);
        this.a.setResultMsg(ContrastPortraitResult.ERROR_MSG_SERVER_ERROR);
        this.b.b(this.a);
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
            this.a.setResultCode(optInt);
            this.a.setResultMsg(optString);
            if (this.a.getResultCode() == 0) {
                JSONObject optJSONObject = new JSONObject(str).optJSONObject("result");
                if (this.b.passFaceRecogDTO.livenessType == PassFaceRecogType.RECOG_TYPE_AUTHTOKEN) {
                    this.a.authsid = optJSONObject.optString("authsid");
                }
                this.a.callbackkey = optJSONObject.optString("callbackkey");
                this.a.contrastres = optJSONObject.optInt("contrastres");
                this.a.finalres = optJSONObject.optInt("finalres");
                this.a.finish = optJSONObject.optInt("finish");
                this.a.imgdigests = optJSONObject.optString("imgdigests");
                this.a.recordvideo = optJSONObject.optInt("recordvideo");
            }
        } catch (JSONException e) {
            Log.e(e);
            this.a.setResultCode(-206);
            this.a.setResultMsg(ContrastPortraitResult.ERROR_MSG_SERVER_ERROR);
        }
        this.b.c(this.a);
    }
}

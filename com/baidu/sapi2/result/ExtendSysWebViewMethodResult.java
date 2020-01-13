package com.baidu.sapi2.result;

import android.text.TextUtils;
import com.baidu.fsg.base.BaiduRimConstants;
import com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ExtendSysWebViewMethodResult extends SapiResult {
    public Map<String, Object> params = new HashMap();
    public PassFaceRecogResult recogResult;

    public JSONObject getJsonResult() {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        PassFaceRecogResult passFaceRecogResult = this.recogResult;
        JSONObject jSONObject3 = (passFaceRecogResult == null || (jSONObject = passFaceRecogResult.extraJson) == null) ? new JSONObject() : jSONObject;
        try {
            if (this.recogResult != null) {
                if (!TextUtils.isEmpty(this.recogResult.authSid)) {
                    jSONObject3.put("authsid", this.recogResult.authSid);
                }
                if (!TextUtils.isEmpty(this.recogResult.authSid)) {
                    jSONObject3.put("authsid", this.recogResult.authSid);
                }
                if (!TextUtils.isEmpty(this.recogResult.video)) {
                    jSONObject3.put("video", this.recogResult.video);
                }
                if (!TextUtils.isEmpty(this.recogResult.callbackkey)) {
                    jSONObject3.put("callbackkey", this.recogResult.callbackkey);
                }
                if (!TextUtils.isEmpty(this.recogResult.faceimage)) {
                    jSONObject3.put("faceimage", this.recogResult.faceimage);
                }
                if (!TextUtils.isEmpty(this.recogResult.imgdigests)) {
                    jSONObject3.put("imgdigests", this.recogResult.imgdigests);
                }
                if (!TextUtils.isEmpty(this.recogResult.originalImage)) {
                    jSONObject3.put("originimage", this.recogResult.originalImage);
                }
            }
            for (Map.Entry<String, Object> entry : this.params.entrySet()) {
                jSONObject3.put(entry.getKey(), entry.getValue().toString());
            }
            jSONObject2.put("result", jSONObject3);
            if (this.recogResult != null) {
                jSONObject2.put(BaiduRimConstants.RETCODE_KEY, this.recogResult.getResultCode());
                jSONObject2.put("retMsg", this.recogResult.getResultMsg());
            }
        } catch (JSONException e) {
        }
        return jSONObject2;
    }
}

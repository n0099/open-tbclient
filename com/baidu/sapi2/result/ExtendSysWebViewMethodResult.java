package com.baidu.sapi2.result;

import android.text.TextUtils;
import com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ExtendSysWebViewMethodResult extends SapiResult {
    public Map<String, Object> params = new HashMap();
    public PassFaceRecogResult recogResult;

    public JSONObject getJsonResult() {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        if (this.recogResult != null && this.recogResult.extraJson != null) {
            jSONObject = this.recogResult.extraJson;
        } else {
            jSONObject = new JSONObject();
        }
        try {
            if (this.recogResult != null) {
                if (!TextUtils.isEmpty(this.recogResult.authSid)) {
                    jSONObject.put("authsid", this.recogResult.authSid);
                }
                if (!TextUtils.isEmpty(this.recogResult.authSid)) {
                    jSONObject.put("authsid", this.recogResult.authSid);
                }
                if (!TextUtils.isEmpty(this.recogResult.video)) {
                    jSONObject.put("video", this.recogResult.video);
                }
                if (!TextUtils.isEmpty(this.recogResult.callbackkey)) {
                    jSONObject.put("callbackkey", this.recogResult.callbackkey);
                }
                if (!TextUtils.isEmpty(this.recogResult.faceimage)) {
                    jSONObject.put("faceimage", this.recogResult.faceimage);
                }
                if (!TextUtils.isEmpty(this.recogResult.imgdigests)) {
                    jSONObject.put("imgdigests", this.recogResult.imgdigests);
                }
                if (!TextUtils.isEmpty(this.recogResult.originalImage)) {
                    jSONObject.put("originimage", this.recogResult.originalImage);
                }
            }
            for (Map.Entry<String, Object> entry : this.params.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue().toString());
            }
            jSONObject2.put("result", jSONObject);
            if (this.recogResult != null) {
                jSONObject2.put("retCode", this.recogResult.getResultCode());
                jSONObject2.put("retMsg", this.recogResult.getResultMsg());
            }
        } catch (JSONException e) {
        }
        return jSONObject2;
    }
}

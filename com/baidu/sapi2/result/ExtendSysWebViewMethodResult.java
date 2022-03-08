package com.baidu.sapi2.result;

import android.text.TextUtils;
import com.baidu.fsg.base.BaiduRimConstants;
import com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ExtendSysWebViewMethodResult extends SapiResult {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, Object> params;
    public PassFaceRecogResult recogResult;

    public ExtendSysWebViewMethodResult() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.params = new HashMap();
    }

    public JSONObject getJsonResult() {
        InterceptResult invokeV;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject2 = new JSONObject();
            PassFaceRecogResult passFaceRecogResult = this.recogResult;
            if (passFaceRecogResult == null || (jSONObject = passFaceRecogResult.extraJson) == null) {
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
                    jSONObject2.put(BaiduRimConstants.RETCODE_KEY, this.recogResult.getResultCode());
                    jSONObject2.put("retMsg", this.recogResult.getResultMsg());
                }
            } catch (JSONException unused) {
            }
            return jSONObject2;
        }
        return (JSONObject) invokeV.objValue;
    }
}

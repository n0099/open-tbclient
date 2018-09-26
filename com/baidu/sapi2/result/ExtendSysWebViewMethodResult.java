package com.baidu.sapi2.result;

import com.baidu.sapi2.base.debug.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ExtendSysWebViewMethodResult extends SapiResult {
    public Map<String, Object> params = new HashMap();

    public JSONObject getJsonResult() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.params.containsKey("result")) {
                JSONObject jSONObject2 = new JSONObject(this.params.get("result").toString());
                this.params.remove("result");
                jSONObject.put("result", jSONObject2);
            }
            for (Map.Entry<String, Object> entry : this.params.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue().toString());
            }
        } catch (Exception e) {
            Log.e(e);
        }
        return jSONObject;
    }
}

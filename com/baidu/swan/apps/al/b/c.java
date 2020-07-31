package com.baidu.swan.apps.al.b;

import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c implements a<JSONObject> {
    private JSONArray cNO;

    public void bE(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.cNO == null) {
                this.cNO = new JSONArray();
            }
            this.cNO.put(jSONObject);
            if (DEBUG) {
                Log.d("WhiteCollector", "FEStage: " + jSONObject);
            }
        }
    }

    public JSONObject aud() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("stageError", this.cNO);
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("WhiteCollector", Log.getStackTraceString(e));
            }
        }
        return jSONObject;
    }

    public void clear() {
        this.cNO = null;
    }
}

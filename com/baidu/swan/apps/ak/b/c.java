package com.baidu.swan.apps.ak.b;

import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c implements a<JSONObject> {
    private JSONArray dxO;

    public void bZ(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.dxO == null) {
                this.dxO = new JSONArray();
            }
            this.dxO.put(jSONObject);
            if (DEBUG) {
                Log.d("WhiteCollector", "FEStage: " + jSONObject);
            }
        }
    }

    public JSONObject aJr() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("stageError", this.dxO);
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("WhiteCollector", Log.getStackTraceString(e));
            }
        }
        return jSONObject;
    }

    public void clear() {
        this.dxO = null;
    }
}

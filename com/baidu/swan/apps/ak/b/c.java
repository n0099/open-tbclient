package com.baidu.swan.apps.ak.b;

import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class c implements a<JSONObject> {
    private JSONArray cWR;

    public void bM(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.cWR == null) {
                this.cWR = new JSONArray();
            }
            this.cWR.put(jSONObject);
            if (DEBUG) {
                Log.d("WhiteCollector", "FEStage: " + jSONObject);
            }
        }
    }

    public JSONObject aCm() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("stageError", this.cWR);
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("WhiteCollector", Log.getStackTraceString(e));
            }
        }
        return jSONObject;
    }

    public void clear() {
        this.cWR = null;
    }
}

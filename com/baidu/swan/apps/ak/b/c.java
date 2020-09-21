package com.baidu.swan.apps.ak.b;

import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c implements a<JSONObject> {
    private JSONArray cYR;

    public void bP(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.cYR == null) {
                this.cYR = new JSONArray();
            }
            this.cYR.put(jSONObject);
            if (DEBUG) {
                Log.d("WhiteCollector", "FEStage: " + jSONObject);
            }
        }
    }

    public JSONObject aCW() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("stageError", this.cYR);
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("WhiteCollector", Log.getStackTraceString(e));
            }
        }
        return jSONObject;
    }

    public void clear() {
        this.cYR = null;
    }
}

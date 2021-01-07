package com.baidu.swan.apps.aj.b;

import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class c implements a<JSONObject> {
    private JSONArray dNr;

    public void cj(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.dNr == null) {
                this.dNr = new JSONArray();
            }
            this.dNr.put(jSONObject);
            if (DEBUG) {
                Log.d("WhiteCollector", "FEStage: " + jSONObject);
            }
        }
    }

    public JSONObject aOQ() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("stageError", this.dNr);
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("WhiteCollector", Log.getStackTraceString(e));
            }
        }
        return jSONObject;
    }

    public void clear() {
        this.dNr = null;
    }
}

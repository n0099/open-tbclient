package com.baidu.swan.apps.aj.b;

import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class c implements a<JSONObject> {
    private JSONArray dIF;

    public void cj(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.dIF == null) {
                this.dIF = new JSONArray();
            }
            this.dIF.put(jSONObject);
            if (DEBUG) {
                Log.d("WhiteCollector", "FEStage: " + jSONObject);
            }
        }
    }

    public JSONObject aKW() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("stageError", this.dIF);
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("WhiteCollector", Log.getStackTraceString(e));
            }
        }
        return jSONObject;
    }

    public void clear() {
        this.dIF = null;
    }
}

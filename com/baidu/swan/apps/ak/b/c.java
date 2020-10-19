package com.baidu.swan.apps.ak.b;

import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c implements a<JSONObject> {
    private JSONArray dlb;

    public void bW(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.dlb == null) {
                this.dlb = new JSONArray();
            }
            this.dlb.put(jSONObject);
            if (DEBUG) {
                Log.d("WhiteCollector", "FEStage: " + jSONObject);
            }
        }
    }

    public JSONObject aFF() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("stageError", this.dlb);
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("WhiteCollector", Log.getStackTraceString(e));
            }
        }
        return jSONObject;
    }

    public void clear() {
        this.dlb = null;
    }
}

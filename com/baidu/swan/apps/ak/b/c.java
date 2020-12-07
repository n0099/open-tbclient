package com.baidu.swan.apps.ak.b;

import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class c implements a<JSONObject> {
    private JSONArray dEN;

    public void cb(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.dEN == null) {
                this.dEN = new JSONArray();
            }
            this.dEN.put(jSONObject);
            if (DEBUG) {
                Log.d("WhiteCollector", "FEStage: " + jSONObject);
            }
        }
    }

    public JSONObject aMz() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("stageError", this.dEN);
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("WhiteCollector", Log.getStackTraceString(e));
            }
        }
        return jSONObject;
    }

    public void clear() {
        this.dEN = null;
    }
}

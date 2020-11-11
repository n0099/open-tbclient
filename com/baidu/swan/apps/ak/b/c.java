package com.baidu.swan.apps.ak.b;

import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c implements a<JSONObject> {
    private JSONArray dzv;

    public void cf(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.dzv == null) {
                this.dzv = new JSONArray();
            }
            this.dzv.put(jSONObject);
            if (DEBUG) {
                Log.d("WhiteCollector", "FEStage: " + jSONObject);
            }
        }
    }

    public JSONObject aJZ() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("stageError", this.dzv);
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("WhiteCollector", Log.getStackTraceString(e));
            }
        }
        return jSONObject;
    }

    public void clear() {
        this.dzv = null;
    }
}

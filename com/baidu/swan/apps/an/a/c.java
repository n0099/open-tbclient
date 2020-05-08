package com.baidu.swan.apps.an.a;

import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c implements a<JSONObject> {
    private JSONArray ctN;

    public void bj(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.ctN == null) {
                this.ctN = new JSONArray();
            }
            this.ctN.put(jSONObject);
            if (DEBUG) {
                Log.d("WhiteCollector", "FEStage: " + jSONObject);
            }
        }
    }

    public JSONObject amT() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("stageError", this.ctN);
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("WhiteCollector", Log.getStackTraceString(e));
            }
        }
        return jSONObject;
    }

    public void clear() {
        this.ctN = null;
    }
}

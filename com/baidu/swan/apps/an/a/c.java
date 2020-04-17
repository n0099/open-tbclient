package com.baidu.swan.apps.an.a;

import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c implements a<JSONObject> {
    private JSONArray ctH;

    public void bj(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.ctH == null) {
                this.ctH = new JSONArray();
            }
            this.ctH.put(jSONObject);
            if (DEBUG) {
                Log.d("WhiteCollector", "FEStage: " + jSONObject);
            }
        }
    }

    public JSONObject amU() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("stageError", this.ctH);
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("WhiteCollector", Log.getStackTraceString(e));
            }
        }
        return jSONObject;
    }

    public void clear() {
        this.ctH = null;
    }
}

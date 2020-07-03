package com.baidu.swan.apps.al.b;

import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c implements a<JSONObject> {
    private JSONArray cKx;

    public void bz(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.cKx == null) {
                this.cKx = new JSONArray();
            }
            this.cKx.put(jSONObject);
            if (DEBUG) {
                Log.d("WhiteCollector", "FEStage: " + jSONObject);
            }
        }
    }

    public JSONObject asg() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("stageError", this.cKx);
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("WhiteCollector", Log.getStackTraceString(e));
            }
        }
        return jSONObject;
    }

    public void clear() {
        this.cKx = null;
    }
}

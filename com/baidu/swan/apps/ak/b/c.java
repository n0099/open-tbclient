package com.baidu.swan.apps.ak.b;

import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c implements a<JSONObject> {
    private JSONArray dtD;

    public void bZ(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.dtD == null) {
                this.dtD = new JSONArray();
            }
            this.dtD.put(jSONObject);
            if (DEBUG) {
                Log.d("WhiteCollector", "FEStage: " + jSONObject);
            }
        }
    }

    public JSONObject aHz() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("stageError", this.dtD);
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("WhiteCollector", Log.getStackTraceString(e));
            }
        }
        return jSONObject;
    }

    public void clear() {
        this.dtD = null;
    }
}

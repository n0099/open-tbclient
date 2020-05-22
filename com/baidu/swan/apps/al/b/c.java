package com.baidu.swan.apps.al.b;

import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c implements a<JSONObject> {
    private JSONArray cFN;

    public void bs(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.cFN == null) {
                this.cFN = new JSONArray();
            }
            this.cFN.put(jSONObject);
            if (DEBUG) {
                Log.d("WhiteCollector", "FEStage: " + jSONObject);
            }
        }
    }

    public JSONObject ara() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("stageError", this.cFN);
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("WhiteCollector", Log.getStackTraceString(e));
            }
        }
        return jSONObject;
    }

    public void clear() {
        this.cFN = null;
    }
}

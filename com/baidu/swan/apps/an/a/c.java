package com.baidu.swan.apps.an.a;

import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c implements a<JSONObject> {
    private JSONArray bUE;

    public void aY(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.bUE == null) {
                this.bUE = new JSONArray();
            }
            this.bUE.put(jSONObject);
            if (DEBUG) {
                Log.d("WhiteCollector", "FEStage: " + jSONObject);
            }
        }
    }

    public JSONObject aeK() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("stageError", this.bUE);
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("WhiteCollector", Log.getStackTraceString(e));
            }
        }
        return jSONObject;
    }

    public void clear() {
        this.bUE = null;
    }
}

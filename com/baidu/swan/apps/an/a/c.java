package com.baidu.swan.apps.an.a;

import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c implements a<JSONObject> {
    private JSONArray bUR;

    public void aY(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.bUR == null) {
                this.bUR = new JSONArray();
            }
            this.bUR.put(jSONObject);
            if (DEBUG) {
                Log.d("WhiteCollector", "FEStage: " + jSONObject);
            }
        }
    }

    public JSONObject aeP() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("stageError", this.bUR);
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("WhiteCollector", Log.getStackTraceString(e));
            }
        }
        return jSONObject;
    }

    public void clear() {
        this.bUR = null;
    }
}

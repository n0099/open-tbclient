package com.baidu.swan.apps.aj.b;

import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class c implements a<JSONObject> {
    private JSONArray dMk;

    public void ci(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.dMk == null) {
                this.dMk = new JSONArray();
            }
            this.dMk.put(jSONObject);
            if (DEBUG) {
                Log.d("WhiteCollector", "FEStage: " + jSONObject);
            }
        }
    }

    public JSONObject aLs() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("stageError", this.dMk);
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("WhiteCollector", Log.getStackTraceString(e));
            }
        }
        return jSONObject;
    }

    public void clear() {
        this.dMk = null;
    }
}

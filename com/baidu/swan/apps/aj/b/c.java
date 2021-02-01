package com.baidu.swan.apps.aj.b;

import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class c implements a<JSONObject> {
    private JSONArray dKJ;

    public void cg(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.dKJ == null) {
                this.dKJ = new JSONArray();
            }
            this.dKJ.put(jSONObject);
            if (DEBUG) {
                Log.d("WhiteCollector", "FEStage: " + jSONObject);
            }
        }
    }

    public JSONObject aLp() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("stageError", this.dKJ);
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("WhiteCollector", Log.getStackTraceString(e));
            }
        }
        return jSONObject;
    }

    public void clear() {
        this.dKJ = null;
    }
}

package com.baidu.swan.apps.an.a;

import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c implements a<JSONObject> {
    private JSONArray bQz;

    public void aY(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.bQz == null) {
                this.bQz = new JSONArray();
            }
            this.bQz.put(jSONObject);
            if (DEBUG) {
                Log.d("WhiteCollector", "FEStage: " + jSONObject);
            }
        }
    }

    public JSONObject acw() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("stageError", this.bQz);
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("WhiteCollector", Log.getStackTraceString(e));
            }
        }
        return jSONObject;
    }

    public void clear() {
        this.bQz = null;
    }
}

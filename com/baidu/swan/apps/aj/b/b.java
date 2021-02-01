package com.baidu.swan.apps.aj.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.performance.e;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class b implements a<JSONObject> {
    private JSONArray dKF = new JSONArray();

    public void add(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.d("LaunchTraceCollector", "event is empty");
                return;
            }
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("actionId", str);
            jSONObject.put("timeStamp", String.valueOf(System.currentTimeMillis()));
            jSONObject.put("info", str2);
            cg(jSONObject);
        } catch (JSONException e) {
            if (DEBUG) {
                Log.w("LaunchTraceCollector", Log.getStackTraceString(e));
            }
        }
    }

    public void cg(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.dKF.put(jSONObject);
        }
    }

    public JSONObject aLp() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("launchLog", this.dKF);
            jSONObject.put("performance", e.aDZ());
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("LaunchTraceCollector", Log.getStackTraceString(e));
            }
        }
        try {
            jSONObject.put("abtest", com.baidu.swan.apps.t.a.awZ().getRawSwitch());
        } catch (Exception e2) {
            if (DEBUG) {
                Log.e("LaunchTraceCollector", Log.getStackTraceString(e2));
            }
        }
        return jSONObject;
    }

    public void clear() {
        this.dKF = new JSONArray();
    }
}

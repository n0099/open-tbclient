package com.baidu.swan.apps.ak.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.performance.e;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b implements a<JSONObject> {
    private JSONArray dtz = new JSONArray();

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
            bZ(jSONObject);
        } catch (JSONException e) {
            if (DEBUG) {
                Log.w("LaunchTraceCollector", Log.getStackTraceString(e));
            }
        }
    }

    public void bZ(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.dtz.put(jSONObject);
        }
    }

    public JSONObject aHz() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("launchLog", this.dtz);
            jSONObject.put("performance", e.aBe());
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("LaunchTraceCollector", Log.getStackTraceString(e));
            }
        }
        try {
            jSONObject.put("abtest", com.baidu.swan.apps.t.a.aud().getRawSwitch());
        } catch (Exception e2) {
            if (DEBUG) {
                Log.e("LaunchTraceCollector", Log.getStackTraceString(e2));
            }
        }
        return jSONObject;
    }

    public void clear() {
        this.dtz = new JSONArray();
    }
}

package com.baidu.swan.apps.ak.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.performance.e;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b implements a<JSONObject> {
    private JSONArray cWJ = new JSONArray();

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
            bM(jSONObject);
        } catch (JSONException e) {
            if (DEBUG) {
                Log.w("LaunchTraceCollector", Log.getStackTraceString(e));
            }
        }
    }

    public void bM(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.cWJ.put(jSONObject);
        }
    }

    public JSONObject aCm() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("launchLog", this.cWJ);
            jSONObject.put("performance", e.avQ());
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("LaunchTraceCollector", Log.getStackTraceString(e));
            }
        }
        try {
            jSONObject.put("abtest", com.baidu.swan.apps.t.a.aoM().getRawSwitch());
        } catch (Exception e2) {
            if (DEBUG) {
                Log.e("LaunchTraceCollector", Log.getStackTraceString(e2));
            }
        }
        return jSONObject;
    }

    public void clear() {
        this.cWJ = new JSONArray();
    }
}

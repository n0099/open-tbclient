package com.baidu.swan.apps.al.b;

import android.text.TextUtils;
import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b implements a<JSONObject> {
    private JSONArray cKt = new JSONArray();

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
            bz(jSONObject);
        } catch (JSONException e) {
            if (DEBUG) {
                Log.w("LaunchTraceCollector", Log.getStackTraceString(e));
            }
        }
    }

    public void bz(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.cKt.put(jSONObject);
        }
    }

    public JSONObject asg() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("launchLog", this.cKt);
            jSONObject.put("performance", com.baidu.swan.apps.performance.c.amB());
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("LaunchTraceCollector", Log.getStackTraceString(e));
            }
        }
        try {
            jSONObject.put("abtest", com.baidu.swan.apps.u.a.aga().getRawSwitch());
        } catch (Exception e2) {
            if (DEBUG) {
                Log.e("LaunchTraceCollector", Log.getStackTraceString(e2));
            }
        }
        return jSONObject;
    }

    public void clear() {
        this.cKt = new JSONArray();
    }
}

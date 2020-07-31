package com.baidu.swan.apps.al.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.performance.e;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b implements a<JSONObject> {
    private JSONArray cNK = new JSONArray();

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
            bE(jSONObject);
        } catch (JSONException e) {
            if (DEBUG) {
                Log.w("LaunchTraceCollector", Log.getStackTraceString(e));
            }
        }
    }

    public void bE(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.cNK.put(jSONObject);
        }
    }

    public JSONObject aud() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("launchLog", this.cNK);
            jSONObject.put("performance", e.anV());
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("LaunchTraceCollector", Log.getStackTraceString(e));
            }
        }
        try {
            jSONObject.put("abtest", com.baidu.swan.apps.t.a.ahm().getRawSwitch());
        } catch (Exception e2) {
            if (DEBUG) {
                Log.e("LaunchTraceCollector", Log.getStackTraceString(e2));
            }
        }
        return jSONObject;
    }

    public void clear() {
        this.cNK = new JSONArray();
    }
}

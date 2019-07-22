package com.baidu.swan.apps.model;

import android.text.TextUtils;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String TAG = "SwanAppParam";
    private boolean aDP;
    private String azs;
    private String mBaseUrl;
    private String mParams;

    public String getPage() {
        return this.azs;
    }

    public String getParams() {
        return this.mParams;
    }

    public String Go() {
        return this.mBaseUrl;
    }

    public void Aq() {
        this.aDP = false;
    }

    public String Hq() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("page", this.azs);
            jSONObject.put("params", this.mParams);
            jSONObject.put("baseUrl", this.mBaseUrl);
            jSONObject.put("isFirstPage", this.aDP);
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e(TAG, "toJSONString error: " + Log.getStackTraceString(e));
            }
        }
        return jSONObject.toString();
    }

    public static c fv(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            c cVar = new c();
            JSONObject jSONObject = new JSONObject(str);
            cVar.azs = jSONObject.optString("page");
            cVar.mParams = jSONObject.optString("params");
            cVar.mBaseUrl = jSONObject.optString("baseUrl");
            cVar.aDP = jSONObject.optBoolean("isFirstPage");
            return cVar;
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e(TAG, "createSwanAppParam() error: " + Log.getStackTraceString(e));
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public static class a {
        private c aqI = new c();

        public a fw(String str) {
            this.aqI.azs = str;
            return this;
        }

        public a fx(String str) {
            this.aqI.mParams = str;
            return this;
        }

        public a fy(String str) {
            this.aqI.mBaseUrl = str;
            return this;
        }

        public a bA(boolean z) {
            this.aqI.aDP = z;
            return this;
        }

        public c Hr() {
            return this.aqI;
        }
    }
}

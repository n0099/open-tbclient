package com.baidu.swan.apps.model;

import android.text.TextUtils;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String TAG = "SwanAppParam";
    private boolean aBC;
    private String axM;
    private String mBaseUrl;
    private String mParams;

    public String getPage() {
        return this.axM;
    }

    public String getParams() {
        return this.mParams;
    }

    public String DJ() {
        return this.mBaseUrl;
    }

    public void yM() {
        this.aBC = false;
    }

    public String EI() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("page", this.axM);
            jSONObject.put("params", this.mParams);
            jSONObject.put("baseUrl", this.mBaseUrl);
            jSONObject.put("isFirstPage", this.aBC);
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e(TAG, "toJSONString error: " + Log.getStackTraceString(e));
            }
        }
        return jSONObject.toString();
    }

    public static c ff(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            c cVar = new c();
            JSONObject jSONObject = new JSONObject(str);
            cVar.axM = jSONObject.optString("page");
            cVar.mParams = jSONObject.optString("params");
            cVar.mBaseUrl = jSONObject.optString("baseUrl");
            cVar.aBC = jSONObject.optBoolean("isFirstPage");
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
        private c apZ = new c();

        public a fg(String str) {
            this.apZ.axM = str;
            return this;
        }

        public a fh(String str) {
            this.apZ.mParams = str;
            return this;
        }

        public a fi(String str) {
            this.apZ.mBaseUrl = str;
            return this;
        }

        public a bp(boolean z) {
            this.apZ.aBC = z;
            return this;
        }

        public c EJ() {
            return this.apZ;
        }
    }
}

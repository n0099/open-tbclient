package com.baidu.swan.apps.model;

import android.text.TextUtils;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String TAG = "SwanAppParam";
    private boolean aBB;
    private String axL;
    private String mBaseUrl;
    private String mParams;

    public String getPage() {
        return this.axL;
    }

    public String getParams() {
        return this.mParams;
    }

    public String DJ() {
        return this.mBaseUrl;
    }

    public void yM() {
        this.aBB = false;
    }

    public String EI() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("page", this.axL);
            jSONObject.put("params", this.mParams);
            jSONObject.put("baseUrl", this.mBaseUrl);
            jSONObject.put("isFirstPage", this.aBB);
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
            cVar.axL = jSONObject.optString("page");
            cVar.mParams = jSONObject.optString("params");
            cVar.mBaseUrl = jSONObject.optString("baseUrl");
            cVar.aBB = jSONObject.optBoolean("isFirstPage");
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
        private c apY = new c();

        public a fg(String str) {
            this.apY.axL = str;
            return this;
        }

        public a fh(String str) {
            this.apY.mParams = str;
            return this;
        }

        public a fi(String str) {
            this.apY.mBaseUrl = str;
            return this;
        }

        public a bp(boolean z) {
            this.apY.aBB = z;
            return this;
        }

        public c EJ() {
            return this.apY;
        }
    }
}

package com.baidu.swan.apps.model;

import android.text.TextUtils;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String TAG = "SwanAppParam";
    private boolean aEn;
    private String azQ;
    private String mBaseUrl;
    private String mParams;

    public String getPage() {
        return this.azQ;
    }

    public String getParams() {
        return this.mParams;
    }

    public String Gs() {
        return this.mBaseUrl;
    }

    public void Au() {
        this.aEn = false;
    }

    public String Hu() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("page", this.azQ);
            jSONObject.put("params", this.mParams);
            jSONObject.put("baseUrl", this.mBaseUrl);
            jSONObject.put("isFirstPage", this.aEn);
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e(TAG, "toJSONString error: " + Log.getStackTraceString(e));
            }
        }
        return jSONObject.toString();
    }

    public static c fx(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            c cVar = new c();
            JSONObject jSONObject = new JSONObject(str);
            cVar.azQ = jSONObject.optString("page");
            cVar.mParams = jSONObject.optString("params");
            cVar.mBaseUrl = jSONObject.optString("baseUrl");
            cVar.aEn = jSONObject.optBoolean("isFirstPage");
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
        private c arg = new c();

        public a fy(String str) {
            this.arg.azQ = str;
            return this;
        }

        public a fz(String str) {
            this.arg.mParams = str;
            return this;
        }

        public a fA(String str) {
            this.arg.mBaseUrl = str;
            return this;
        }

        public a bA(boolean z) {
            this.arg.aEn = z;
            return this;
        }

        public c Hv() {
            return this.arg;
        }
    }
}

package com.baidu.swan.apps.model;

import android.text.TextUtils;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String TAG = "SwanAppParam";
    private boolean cvK;
    private String mBaseUrl;
    private String mPage;
    private String mParams;

    public String getPage() {
        return this.mPage;
    }

    public String getParams() {
        return this.mParams;
    }

    public String ajY() {
        return this.mBaseUrl;
    }

    public void aaY() {
        this.cvK = false;
    }

    public String toJSONString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("page", this.mPage);
            jSONObject.put("params", this.mParams);
            jSONObject.put("baseUrl", this.mBaseUrl);
            jSONObject.put("isFirstPage", this.cvK);
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e(TAG, "toJSONString error: " + Log.getStackTraceString(e));
            }
        }
        return jSONObject.toString();
    }

    public static c mC(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            c cVar = new c();
            JSONObject jSONObject = new JSONObject(str);
            cVar.mPage = jSONObject.optString("page");
            cVar.mParams = jSONObject.optString("params");
            cVar.mBaseUrl = jSONObject.optString("baseUrl");
            cVar.cvK = jSONObject.optBoolean("isFirstPage");
            return cVar;
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e(TAG, "createSwanAppParam() error: " + Log.getStackTraceString(e));
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes7.dex */
    public static class a {
        private c cbr = new c();

        public a mD(String str) {
            this.cbr.mPage = str;
            return this;
        }

        public a mE(String str) {
            this.cbr.mParams = str;
            return this;
        }

        public a mF(String str) {
            this.cbr.mBaseUrl = str;
            return this;
        }

        public a eB(boolean z) {
            this.cbr.cvK = z;
            return this;
        }

        public c amp() {
            return this.cbr;
        }
    }
}

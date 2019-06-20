package com.baidu.swan.apps.model;

import android.text.TextUtils;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String TAG = "SwanAppParam";
    private boolean aDh;
    private String ayL;
    private String mBaseUrl;
    private String mParams;

    public String getPage() {
        return this.ayL;
    }

    public String getParams() {
        return this.mParams;
    }

    public String FE() {
        return this.mBaseUrl;
    }

    public void zJ() {
        this.aDh = false;
    }

    public String GG() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("page", this.ayL);
            jSONObject.put("params", this.mParams);
            jSONObject.put("baseUrl", this.mBaseUrl);
            jSONObject.put("isFirstPage", this.aDh);
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e(TAG, "toJSONString error: " + Log.getStackTraceString(e));
            }
        }
        return jSONObject.toString();
    }

    public static c fq(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            c cVar = new c();
            JSONObject jSONObject = new JSONObject(str);
            cVar.ayL = jSONObject.optString("page");
            cVar.mParams = jSONObject.optString("params");
            cVar.mBaseUrl = jSONObject.optString("baseUrl");
            cVar.aDh = jSONObject.optBoolean("isFirstPage");
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
        private c aqf = new c();

        public a fr(String str) {
            this.aqf.ayL = str;
            return this;
        }

        public a fs(String str) {
            this.aqf.mParams = str;
            return this;
        }

        public a ft(String str) {
            this.aqf.mBaseUrl = str;
            return this;
        }

        public a bx(boolean z) {
            this.aqf.aDh = z;
            return this;
        }

        public c GH() {
            return this.aqf;
        }
    }
}

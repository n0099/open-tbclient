package com.baidu.swan.apps.model;

import android.text.TextUtils;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String TAG = "SwanAppParam";
    private String aTe;
    private boolean aXC;
    private String mBaseUrl;
    private String mParams;

    public String getPage() {
        return this.aTe;
    }

    public String getParams() {
        return this.mParams;
    }

    public String Lm() {
        return this.mBaseUrl;
    }

    public void Fp() {
        this.aXC = false;
    }

    public String Mo() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("page", this.aTe);
            jSONObject.put("params", this.mParams);
            jSONObject.put("baseUrl", this.mBaseUrl);
            jSONObject.put("isFirstPage", this.aXC);
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e(TAG, "toJSONString error: " + Log.getStackTraceString(e));
            }
        }
        return jSONObject.toString();
    }

    public static c gb(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            c cVar = new c();
            JSONObject jSONObject = new JSONObject(str);
            cVar.aTe = jSONObject.optString("page");
            cVar.mParams = jSONObject.optString("params");
            cVar.mBaseUrl = jSONObject.optString("baseUrl");
            cVar.aXC = jSONObject.optBoolean("isFirstPage");
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
        private c aKw = new c();

        public a gc(String str) {
            this.aKw.aTe = str;
            return this;
        }

        public a gd(String str) {
            this.aKw.mParams = str;
            return this;
        }

        public a ge(String str) {
            this.aKw.mBaseUrl = str;
            return this;
        }

        public a bS(boolean z) {
            this.aKw.aXC = z;
            return this;
        }

        public c Mp() {
            return this.aKw;
        }
    }
}

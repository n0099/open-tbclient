package com.baidu.swan.apps.model;

import android.text.TextUtils;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String TAG = "SwanAppParam";
    private boolean coU;
    private String mBaseUrl;
    private String mPage;
    private String mParams;

    public String getPage() {
        return this.mPage;
    }

    public String getParams() {
        return this.mParams;
    }

    public String ahC() {
        return this.mBaseUrl;
    }

    public void YO() {
        this.coU = false;
    }

    public String toJSONString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("page", this.mPage);
            jSONObject.put("params", this.mParams);
            jSONObject.put("baseUrl", this.mBaseUrl);
            jSONObject.put("isFirstPage", this.coU);
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e(TAG, "toJSONString error: " + Log.getStackTraceString(e));
            }
        }
        return jSONObject.toString();
    }

    public static c lW(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            c cVar = new c();
            JSONObject jSONObject = new JSONObject(str);
            cVar.mPage = jSONObject.optString("page");
            cVar.mParams = jSONObject.optString("params");
            cVar.mBaseUrl = jSONObject.optString("baseUrl");
            cVar.coU = jSONObject.optBoolean("isFirstPage");
            return cVar;
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e(TAG, "createSwanAppParam() error: " + Log.getStackTraceString(e));
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes11.dex */
    public static class a {
        private c bUY = new c();

        public a lX(String str) {
            this.bUY.mPage = str;
            return this;
        }

        public a lY(String str) {
            this.bUY.mParams = str;
            return this;
        }

        public a lZ(String str) {
            this.bUY.mBaseUrl = str;
            return this;
        }

        public a eo(boolean z) {
            this.bUY.coU = z;
            return this;
        }

        public c ajS() {
            return this.bUY;
        }
    }
}

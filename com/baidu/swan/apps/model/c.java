package com.baidu.swan.apps.model;

import android.text.TextUtils;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String TAG = "SwanAppParam";
    private boolean bBf;
    private String mBaseUrl;
    private String mPage;
    private String mParams;

    public String getPage() {
        return this.mPage;
    }

    public String getParams() {
        return this.mParams;
    }

    public String Uk() {
        return this.mBaseUrl;
    }

    public void LW() {
        this.bBf = false;
    }

    public String toJSONString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("page", this.mPage);
            jSONObject.put("params", this.mParams);
            jSONObject.put("baseUrl", this.mBaseUrl);
            jSONObject.put("isFirstPage", this.bBf);
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e(TAG, "toJSONString error: " + Log.getStackTraceString(e));
            }
        }
        return jSONObject.toString();
    }

    public static c jh(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            c cVar = new c();
            JSONObject jSONObject = new JSONObject(str);
            cVar.mPage = jSONObject.optString("page");
            cVar.mParams = jSONObject.optString("params");
            cVar.mBaseUrl = jSONObject.optString("baseUrl");
            cVar.bBf = jSONObject.optBoolean("isFirstPage");
            return cVar;
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e(TAG, "createSwanAppParam() error: " + Log.getStackTraceString(e));
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes10.dex */
    public static class a {
        private c bjj = new c();

        public a ji(String str) {
            this.bjj.mPage = str;
            return this;
        }

        public a jj(String str) {
            this.bjj.mParams = str;
            return this;
        }

        public a jk(String str) {
            this.bjj.mBaseUrl = str;
            return this;
        }

        public a cT(boolean z) {
            this.bjj.bBf = z;
            return this;
        }

        public c Wf() {
            return this.bjj;
        }
    }
}

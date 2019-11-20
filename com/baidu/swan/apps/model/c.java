package com.baidu.swan.apps.model;

import android.text.TextUtils;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String TAG = "SwanAppParam";
    private String aSM;
    private boolean aXk;
    private String mBaseUrl;
    private String mParams;

    public String getPage() {
        return this.aSM;
    }

    public String getParams() {
        return this.mParams;
    }

    public String Ln() {
        return this.mBaseUrl;
    }

    public void Fq() {
        this.aXk = false;
    }

    public String Mp() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("page", this.aSM);
            jSONObject.put("params", this.mParams);
            jSONObject.put("baseUrl", this.mBaseUrl);
            jSONObject.put("isFirstPage", this.aXk);
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
            cVar.aSM = jSONObject.optString("page");
            cVar.mParams = jSONObject.optString("params");
            cVar.mBaseUrl = jSONObject.optString("baseUrl");
            cVar.aXk = jSONObject.optBoolean("isFirstPage");
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
        private c aKe = new c();

        public a gc(String str) {
            this.aKe.aSM = str;
            return this;
        }

        public a gd(String str) {
            this.aKe.mParams = str;
            return this;
        }

        public a ge(String str) {
            this.aKe.mBaseUrl = str;
            return this;
        }

        public a bS(boolean z) {
            this.aKe.aXk = z;
            return this;
        }

        public c Mq() {
            return this.aKe;
        }
    }
}

package com.baidu.swan.apps.model;

import android.text.TextUtils;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String TAG = "SwanAppParam";
    private boolean dge;
    private String mBaseUrl;
    private String mPage;
    private String mParams;

    public String getPage() {
        return this.mPage;
    }

    public String getParams() {
        return this.mParams;
    }

    public String azv() {
        return this.mBaseUrl;
    }

    public void aoY() {
        this.dge = false;
    }

    public String toJSONString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("page", this.mPage);
            jSONObject.put("params", this.mParams);
            jSONObject.put("baseUrl", this.mBaseUrl);
            jSONObject.put("isFirstPage", this.dge);
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e(TAG, "toJSONString error: " + Log.getStackTraceString(e));
            }
        }
        return jSONObject.toString();
    }

    public static c qo(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            c cVar = new c();
            JSONObject jSONObject = new JSONObject(str);
            cVar.mPage = jSONObject.optString("page");
            cVar.mParams = jSONObject.optString("params");
            cVar.mBaseUrl = jSONObject.optString("baseUrl");
            cVar.dge = jSONObject.optBoolean("isFirstPage");
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
        private c cJZ = new c();

        public a qp(String str) {
            this.cJZ.mPage = str;
            return this;
        }

        public a qq(String str) {
            this.cJZ.mParams = str;
            return this;
        }

        public a qr(String str) {
            this.cJZ.mBaseUrl = str;
            return this;
        }

        public a fJ(boolean z) {
            this.cJZ.dge = z;
            return this;
        }

        public c aBZ() {
            return this.cJZ;
        }
    }
}

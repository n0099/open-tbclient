package com.baidu.swan.apps.model;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String TAG = "SwanAppParam";
    private boolean aBy;
    private String axI;
    private String mBaseUrl;
    private String mParams;

    public String getPage() {
        return this.axI;
    }

    public String getParams() {
        return this.mParams;
    }

    public String DL() {
        return this.mBaseUrl;
    }

    public void yN() {
        this.aBy = false;
    }

    public String EK() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("page", this.axI);
            jSONObject.put(LegoListActivityConfig.PARAMS, this.mParams);
            jSONObject.put("baseUrl", this.mBaseUrl);
            jSONObject.put("isFirstPage", this.aBy);
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e(TAG, "toJSONString error: " + Log.getStackTraceString(e));
            }
        }
        return jSONObject.toString();
    }

    public static c fe(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            c cVar = new c();
            JSONObject jSONObject = new JSONObject(str);
            cVar.axI = jSONObject.optString("page");
            cVar.mParams = jSONObject.optString(LegoListActivityConfig.PARAMS);
            cVar.mBaseUrl = jSONObject.optString("baseUrl");
            cVar.aBy = jSONObject.optBoolean("isFirstPage");
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
        private c apU = new c();

        public a ff(String str) {
            this.apU.axI = str;
            return this;
        }

        public a fg(String str) {
            this.apU.mParams = str;
            return this;
        }

        public a fh(String str) {
            this.apU.mBaseUrl = str;
            return this;
        }

        public a bp(boolean z) {
            this.apU.aBy = z;
            return this;
        }

        public c EL() {
            return this.apU;
        }
    }
}

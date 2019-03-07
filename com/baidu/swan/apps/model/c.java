package com.baidu.swan.apps.model;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class c {
    private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    private static String TAG = "SwanAppParam";
    private boolean aBx;
    private String axH;
    private String mBaseUrl;
    private String mParams;

    public String getPage() {
        return this.axH;
    }

    public String getParams() {
        return this.mParams;
    }

    public String DL() {
        return this.mBaseUrl;
    }

    public void yN() {
        this.aBx = false;
    }

    public String EK() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("page", this.axH);
            jSONObject.put(LegoListActivityConfig.PARAMS, this.mParams);
            jSONObject.put("baseUrl", this.mBaseUrl);
            jSONObject.put("isFirstPage", this.aBx);
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
            cVar.axH = jSONObject.optString("page");
            cVar.mParams = jSONObject.optString(LegoListActivityConfig.PARAMS);
            cVar.mBaseUrl = jSONObject.optString("baseUrl");
            cVar.aBx = jSONObject.optBoolean("isFirstPage");
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
        private c apT = new c();

        public a ff(String str) {
            this.apT.axH = str;
            return this;
        }

        public a fg(String str) {
            this.apT.mParams = str;
            return this;
        }

        public a fh(String str) {
            this.apT.mBaseUrl = str;
            return this;
        }

        public a bp(boolean z) {
            this.apT.aBx = z;
            return this;
        }

        public c EL() {
            return this.apT;
        }
    }
}

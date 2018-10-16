package com.baidu.searchbox.ng.ai.apps.model;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class AiAppsParam {
    private static final boolean DEBUG = false;
    private static final String JSON_BASE_URL_KEY = "baseUrl";
    private static final String JSON_PAGE_KEY = "page";
    private static final String JSON_PAGE_PARAMS_KEY = "params";
    private static String TAG = "AiAppsParam";
    private String mBaseUrl;
    private String mPage;
    private String mParams;

    public String getPage() {
        return this.mPage;
    }

    public String getParams() {
        return this.mParams;
    }

    public String getBaseUrl() {
        return this.mBaseUrl;
    }

    public String toJSONString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("page", this.mPage);
            jSONObject.put("params", this.mParams);
            jSONObject.put(JSON_BASE_URL_KEY, this.mBaseUrl);
        } catch (JSONException e) {
        }
        return jSONObject.toString();
    }

    public static AiAppsParam createAiAppsParam(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            AiAppsParam aiAppsParam = new AiAppsParam();
            JSONObject jSONObject = new JSONObject(str);
            aiAppsParam.mPage = jSONObject.optString("page");
            aiAppsParam.mParams = jSONObject.optString("params");
            aiAppsParam.mBaseUrl = jSONObject.optString(JSON_BASE_URL_KEY);
            return aiAppsParam;
        } catch (JSONException e) {
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public static class Builder {
        private AiAppsParam mParam = new AiAppsParam();

        public Builder setPage(String str) {
            this.mParam.mPage = str;
            return this;
        }

        public Builder setParams(String str) {
            this.mParam.mParams = str;
            return this;
        }

        public Builder setBaseUrl(String str) {
            this.mParam.mBaseUrl = str;
            return this;
        }

        public AiAppsParam build() {
            return this.mParam;
        }
    }
}

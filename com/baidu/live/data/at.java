package com.baidu.live.data;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class at {
    private String aPv;
    private String mDownloadUrl;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mDownloadUrl = jSONObject.optString("url");
            this.aPv = jSONObject.optString("md5");
        }
    }

    public String getDownloadUrl() {
        return this.mDownloadUrl;
    }

    public String FN() {
        return this.aPv;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", this.mDownloadUrl);
            jSONObject.put("md5", this.aPv);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}

package com.baidu.live.data;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class az {
    private String aOu;
    private String mDownloadUrl;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mDownloadUrl = jSONObject.optString("url");
            this.aOu = jSONObject.optString("md5");
        }
    }

    public String getDownloadUrl() {
        return this.mDownloadUrl;
    }

    public String Cv() {
        return this.aOu;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", this.mDownloadUrl);
            jSONObject.put("md5", this.aOu);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}

package com.baidu.live.data;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class as {
    private String aOh;
    private String mDownloadUrl;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mDownloadUrl = jSONObject.optString("url");
            this.aOh = jSONObject.optString("md5");
        }
    }

    public String getDownloadUrl() {
        return this.mDownloadUrl;
    }

    public String EL() {
        return this.aOh;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", this.mDownloadUrl);
            jSONObject.put("md5", this.aOh);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}

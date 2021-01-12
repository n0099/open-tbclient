package com.baidu.live.data;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class av {
    private String aLx;
    private String mDownloadUrl;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mDownloadUrl = jSONObject.optString("url");
            this.aLx = jSONObject.optString("md5");
        }
    }

    public String getDownloadUrl() {
        return this.mDownloadUrl;
    }

    public String Bi() {
        return this.aLx;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", this.mDownloadUrl);
            jSONObject.put("md5", this.aLx);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}

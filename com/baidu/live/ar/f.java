package com.baidu.live.ar;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public class f {
    private String aAd;
    private int azP;
    private String mFile;
    private String mId;
    private String mName;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mId = jSONObject.optString("id");
            this.mName = jSONObject.optString("name");
            this.mFile = jSONObject.optString("file");
            this.aAd = jSONObject.optString("bgurl");
            this.azP = jSONObject.optInt("effect");
        }
    }

    public String getName() {
        return this.mName;
    }

    public String AP() {
        return this.mFile;
    }

    public String AO() {
        return this.aAd;
    }

    public int AS() {
        return this.azP;
    }
}

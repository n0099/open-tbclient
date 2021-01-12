package com.baidu.live.ar;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class h {
    private String aAS;
    private String aBl;
    private String aBm;
    private String aBn;
    private String mFile;
    private String mId;
    private String mName;
    private String mType;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mId = jSONObject.optString("id");
            this.mName = jSONObject.optString("name");
            this.aBl = jSONObject.optString("bgurl");
            this.mType = jSONObject.optString("type");
            this.aBm = jSONObject.optString("current");
            this.mFile = jSONObject.optString("feature_file");
            this.aBn = jSONObject.optString("feature_file_token");
            this.aAS = jSONObject.optString("thinface_value");
        }
    }

    public String yP() {
        return this.aBl;
    }

    public String yQ() {
        return this.mFile;
    }

    public String getName() {
        return this.mName;
    }

    public String getType() {
        return this.mType;
    }

    public String yR() {
        return this.aBm;
    }

    public String yS() {
        return this.aAS;
    }
}

package com.baidu.live.ar;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class h {
    private String aDX;
    private String aEq;
    private String aEr;
    private String aEs;
    private String mFile;
    private String mId;
    private String mName;
    private String mType;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mId = jSONObject.optString("id");
            this.mName = jSONObject.optString("name");
            this.aEq = jSONObject.optString("bgurl");
            this.mType = jSONObject.optString("type");
            this.aEr = jSONObject.optString("current");
            this.mFile = jSONObject.optString("feature_file");
            this.aEs = jSONObject.optString("feature_file_token");
            this.aDX = jSONObject.optString("thinface_value");
        }
    }

    public String zz() {
        return this.aEq;
    }

    public String zA() {
        return this.mFile;
    }

    public String getName() {
        return this.mName;
    }

    public String getType() {
        return this.mType;
    }

    public String zB() {
        return this.aEr;
    }

    public String zC() {
        return this.aDX;
    }
}

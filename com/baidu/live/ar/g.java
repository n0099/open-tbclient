package com.baidu.live.ar;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class g {
    private String aEL;
    private String aEM;
    private String aEN;
    private String aEs;
    private String mFile;
    private String mId;
    private String mName;
    private String mType;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mId = jSONObject.optString("id");
            this.mName = jSONObject.optString("name");
            this.aEL = jSONObject.optString("bgurl");
            this.mType = jSONObject.optString("type");
            this.aEM = jSONObject.optString("current");
            this.mFile = jSONObject.optString("feature_file");
            this.aEN = jSONObject.optString("feature_file_token");
            this.aEs = jSONObject.optString("thinface_value");
        }
    }

    public String Ct() {
        return this.aEL;
    }

    public String Cu() {
        return this.mFile;
    }

    public String getName() {
        return this.mName;
    }

    public String getType() {
        return this.mType;
    }

    public String Cv() {
        return this.aEM;
    }

    public String Cw() {
        return this.aEs;
    }
}

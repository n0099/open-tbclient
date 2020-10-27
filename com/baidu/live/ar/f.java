package com.baidu.live.ar;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class f {
    private String aDL;
    private String aDV;
    private String aDW;
    private String aDX;
    private String mFile;
    private String mId;
    private String mName;
    private String mType;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mId = jSONObject.optString("id");
            this.mName = jSONObject.optString("name");
            this.aDV = jSONObject.optString("bgurl");
            this.mType = jSONObject.optString("type");
            this.aDW = jSONObject.optString("current");
            this.mFile = jSONObject.optString("feature_file");
            this.aDX = jSONObject.optString("feature_file_token");
            this.aDL = jSONObject.optString("thinface_value");
        }
    }

    public String Cb() {
        return this.aDV;
    }

    public String Cc() {
        return this.mFile;
    }

    public String getName() {
        return this.mName;
    }

    public String getType() {
        return this.mType;
    }

    public String Cd() {
        return this.aDW;
    }

    public String Ce() {
        return this.aDL;
    }
}

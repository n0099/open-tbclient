package com.baidu.live.ar;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class e {
    private String aDH;
    private String aDO;
    private String aDP;
    private String aDQ;
    private String mFile;
    private String mId;
    private String mName;
    private String mType;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mId = jSONObject.optString("id");
            this.mName = jSONObject.optString("name");
            this.aDO = jSONObject.optString("bgurl");
            this.mType = jSONObject.optString("type");
            this.aDP = jSONObject.optString("current");
            this.mFile = jSONObject.optString("feature_file");
            this.aDQ = jSONObject.optString("feature_file_token");
            this.aDH = jSONObject.optString("thinface_value");
        }
    }

    public String Ca() {
        return this.aDO;
    }

    public String Cb() {
        return this.mFile;
    }

    public String getName() {
        return this.mName;
    }

    public String getType() {
        return this.mType;
    }

    public String Cc() {
        return this.aDP;
    }

    public String Cd() {
        return this.aDH;
    }
}

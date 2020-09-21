package com.baidu.live.ar;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class e {
    private String aAC;
    private String aAJ;
    private String aAK;
    private String aAL;
    private String mFile;
    private String mId;
    private String mName;
    private String mType;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mId = jSONObject.optString("id");
            this.mName = jSONObject.optString("name");
            this.aAJ = jSONObject.optString("bgurl");
            this.mType = jSONObject.optString("type");
            this.aAK = jSONObject.optString("current");
            this.mFile = jSONObject.optString("feature_file");
            this.aAL = jSONObject.optString("feature_file_token");
            this.aAC = jSONObject.optString("thinface_value");
        }
    }

    public String Bd() {
        return this.aAJ;
    }

    public String Be() {
        return this.mFile;
    }

    public String getName() {
        return this.mName;
    }

    public String getType() {
        return this.mType;
    }

    public String Bf() {
        return this.aAK;
    }

    public String Bg() {
        return this.aAC;
    }
}

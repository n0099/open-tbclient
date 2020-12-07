package com.baidu.live.ar;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class g {
    private String aFG;
    private String aFH;
    private String aFI;
    private String aFn;
    private String mFile;
    private String mId;
    private String mName;
    private String mType;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mId = jSONObject.optString("id");
            this.mName = jSONObject.optString("name");
            this.aFG = jSONObject.optString("bgurl");
            this.mType = jSONObject.optString("type");
            this.aFH = jSONObject.optString("current");
            this.mFile = jSONObject.optString("feature_file");
            this.aFI = jSONObject.optString("feature_file_token");
            this.aFn = jSONObject.optString("thinface_value");
        }
    }

    public String Du() {
        return this.aFG;
    }

    public String Dv() {
        return this.mFile;
    }

    public String getName() {
        return this.mName;
    }

    public String getType() {
        return this.mType;
    }

    public String Dw() {
        return this.aFH;
    }

    public String Dx() {
        return this.aFn;
    }
}

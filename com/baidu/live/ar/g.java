package com.baidu.live.ar;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class g {
    private String aCH;
    private String aDa;
    private String aDb;
    private String aDc;
    private String mFile;
    private String mId;
    private String mName;
    private String mType;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mId = jSONObject.optString("id");
            this.mName = jSONObject.optString("name");
            this.aDa = jSONObject.optString("bgurl");
            this.mType = jSONObject.optString("type");
            this.aDb = jSONObject.optString("current");
            this.mFile = jSONObject.optString("feature_file");
            this.aDc = jSONObject.optString("feature_file_token");
            this.aCH = jSONObject.optString("thinface_value");
        }
    }

    public String BK() {
        return this.aDa;
    }

    public String BL() {
        return this.mFile;
    }

    public String getName() {
        return this.mName;
    }

    public String getType() {
        return this.mType;
    }

    public String BM() {
        return this.aDb;
    }

    public String BN() {
        return this.aCH;
    }
}

package com.baidu.live.ar;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public class e {
    private String aAb;
    private String aAc;
    private String aAd;
    private String azU;
    private String mFile;
    private String mId;
    private String mName;
    private String mType;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mId = jSONObject.optString("id");
            this.mName = jSONObject.optString("name");
            this.aAb = jSONObject.optString("bgurl");
            this.mType = jSONObject.optString("type");
            this.aAc = jSONObject.optString("current");
            this.mFile = jSONObject.optString("feature_file");
            this.aAd = jSONObject.optString("feature_file_token");
            this.azU = jSONObject.optString("thinface_value");
        }
    }

    public String AO() {
        return this.aAb;
    }

    public String AP() {
        return this.mFile;
    }

    public String getName() {
        return this.mName;
    }

    public String getType() {
        return this.mType;
    }

    public String AQ() {
        return this.aAc;
    }

    public String AR() {
        return this.azU;
    }
}

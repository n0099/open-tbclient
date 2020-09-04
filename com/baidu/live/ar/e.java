package com.baidu.live.ar;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public class e {
    private String aAd;
    private String aAe;
    private String aAf;
    private String azW;
    private String mFile;
    private String mId;
    private String mName;
    private String mType;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mId = jSONObject.optString("id");
            this.mName = jSONObject.optString("name");
            this.aAd = jSONObject.optString("bgurl");
            this.mType = jSONObject.optString("type");
            this.aAe = jSONObject.optString("current");
            this.mFile = jSONObject.optString("feature_file");
            this.aAf = jSONObject.optString("feature_file_token");
            this.azW = jSONObject.optString("thinface_value");
        }
    }

    public String AO() {
        return this.aAd;
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
        return this.aAe;
    }

    public String AR() {
        return this.azW;
    }
}

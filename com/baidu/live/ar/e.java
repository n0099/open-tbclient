package com.baidu.live.ar;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e {
    private String auW;
    private String avd;
    private String ave;
    private String avf;
    private String mFile;
    private String mId;
    private String mName;
    private String mType;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mId = jSONObject.optString("id");
            this.mName = jSONObject.optString("name");
            this.avd = jSONObject.optString("bgurl");
            this.mType = jSONObject.optString("type");
            this.ave = jSONObject.optString("current");
            this.mFile = jSONObject.optString("feature_file");
            this.avf = jSONObject.optString("feature_file_token");
            this.auW = jSONObject.optString("thinface_value");
        }
    }

    public String vq() {
        return this.avd;
    }

    public String vr() {
        return this.mFile;
    }

    public String getName() {
        return this.mName;
    }

    public String getType() {
        return this.mType;
    }

    public String vs() {
        return this.ave;
    }

    public String vt() {
        return this.auW;
    }
}

package com.baidu.live.ar;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class e {
    private String auS;
    private String auZ;
    private String ava;
    private String avb;
    private String mFile;
    private String mId;
    private String mName;
    private String mType;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mId = jSONObject.optString("id");
            this.mName = jSONObject.optString("name");
            this.auZ = jSONObject.optString("bgurl");
            this.mType = jSONObject.optString("type");
            this.ava = jSONObject.optString("current");
            this.mFile = jSONObject.optString("feature_file");
            this.avb = jSONObject.optString("feature_file_token");
            this.auS = jSONObject.optString("thinface_value");
        }
    }

    public String vq() {
        return this.auZ;
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
        return this.ava;
    }

    public String vt() {
        return this.auS;
    }
}

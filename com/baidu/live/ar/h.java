package com.baidu.live.ar;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class h {
    private String aCQ;
    private String aCR;
    private String aCS;
    private String aCx;
    private String mFile;
    private String mId;
    private String mName;
    private String mType;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mId = jSONObject.optString("id");
            this.mName = jSONObject.optString("name");
            this.aCQ = jSONObject.optString("bgurl");
            this.mType = jSONObject.optString("type");
            this.aCR = jSONObject.optString("current");
            this.mFile = jSONObject.optString("feature_file");
            this.aCS = jSONObject.optString("feature_file_token");
            this.aCx = jSONObject.optString("thinface_value");
        }
    }

    public String zw() {
        return this.aCQ;
    }

    public String zx() {
        return this.mFile;
    }

    public String getName() {
        return this.mName;
    }

    public String getType() {
        return this.mType;
    }

    public String zy() {
        return this.aCR;
    }

    public String zz() {
        return this.aCx;
    }
}

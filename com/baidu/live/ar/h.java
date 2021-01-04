package com.baidu.live.ar;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class h {
    private String aFF;
    private String aFY;
    private String aFZ;
    private String aGa;
    private String mFile;
    private String mId;
    private String mName;
    private String mType;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mId = jSONObject.optString("id");
            this.mName = jSONObject.optString("name");
            this.aFY = jSONObject.optString("bgurl");
            this.mType = jSONObject.optString("type");
            this.aFZ = jSONObject.optString("current");
            this.mFile = jSONObject.optString("feature_file");
            this.aGa = jSONObject.optString("feature_file_token");
            this.aFF = jSONObject.optString("thinface_value");
        }
    }

    public String CK() {
        return this.aFY;
    }

    public String CL() {
        return this.mFile;
    }

    public String getName() {
        return this.mName;
    }

    public String getType() {
        return this.mType;
    }

    public String CM() {
        return this.aFZ;
    }

    public String CN() {
        return this.aFF;
    }
}

package com.baidu.live.ar;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f {
    private int auP;
    private String avd;
    private String mFile;
    private String mId;
    private String mName;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mId = jSONObject.optString("id");
            this.mName = jSONObject.optString("name");
            this.mFile = jSONObject.optString("file");
            this.avd = jSONObject.optString("bgurl");
            this.auP = jSONObject.optInt("effect");
        }
    }

    public String getName() {
        return this.mName;
    }

    public String vr() {
        return this.mFile;
    }

    public String vq() {
        return this.avd;
    }

    public int vu() {
        return this.auP;
    }
}

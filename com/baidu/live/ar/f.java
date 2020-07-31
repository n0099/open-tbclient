package com.baidu.live.ar;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class f {
    private int auL;
    private String auZ;
    private String mFile;
    private String mId;
    private String mName;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mId = jSONObject.optString("id");
            this.mName = jSONObject.optString("name");
            this.mFile = jSONObject.optString("file");
            this.auZ = jSONObject.optString("bgurl");
            this.auL = jSONObject.optInt("effect");
        }
    }

    public String getName() {
        return this.mName;
    }

    public String vr() {
        return this.mFile;
    }

    public String vq() {
        return this.auZ;
    }

    public int vu() {
        return this.auL;
    }
}

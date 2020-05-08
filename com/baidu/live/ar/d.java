package com.baidu.live.ar;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d {
    private int anZ;
    private String aoj;
    private String mFile;
    private String mId;
    private String mName;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mId = jSONObject.optString("id");
            this.mName = jSONObject.optString("name");
            this.mFile = jSONObject.optString("file");
            this.aoj = jSONObject.optString("bgurl");
            this.anZ = jSONObject.optInt("effect");
        }
    }

    public String getName() {
        return this.mName;
    }

    public String tQ() {
        return this.mFile;
    }

    public String tR() {
        return this.aoj;
    }

    public int tS() {
        return this.anZ;
    }
}

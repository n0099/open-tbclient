package com.baidu.live.ar;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d {
    private int anT;
    private String aod;
    private String mFile;
    private String mId;
    private String mName;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mId = jSONObject.optString("id");
            this.mName = jSONObject.optString("name");
            this.mFile = jSONObject.optString("file");
            this.aod = jSONObject.optString("bgurl");
            this.anT = jSONObject.optInt("effect");
        }
    }

    public String getName() {
        return this.mName;
    }

    public String tR() {
        return this.mFile;
    }

    public String tS() {
        return this.aod;
    }

    public int tT() {
        return this.anT;
    }
}

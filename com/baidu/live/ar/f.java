package com.baidu.live.ar;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class f {
    private int aDA;
    private String aDO;
    private String mFile;
    private String mId;
    private String mName;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mId = jSONObject.optString("id");
            this.mName = jSONObject.optString("name");
            this.mFile = jSONObject.optString("file");
            this.aDO = jSONObject.optString("bgurl");
            this.aDA = jSONObject.optInt("effect");
        }
    }

    public String getName() {
        return this.mName;
    }

    public String Cb() {
        return this.mFile;
    }

    public String Ca() {
        return this.aDO;
    }

    public int Ce() {
        return this.aDA;
    }
}

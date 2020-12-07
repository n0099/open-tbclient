package com.baidu.live.ar;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class h {
    private String aFG;
    private int aFg;
    private String mFile;
    private String mId;
    private String mName;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mId = jSONObject.optString("id");
            this.mName = jSONObject.optString("name");
            this.mFile = jSONObject.optString("file");
            this.aFG = jSONObject.optString("bgurl");
            this.aFg = jSONObject.optInt("effect");
        }
    }

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public String Dv() {
        return this.mFile;
    }

    public String Du() {
        return this.aFG;
    }

    public int Dy() {
        return this.aFg;
    }
}

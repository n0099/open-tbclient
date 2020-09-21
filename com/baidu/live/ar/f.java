package com.baidu.live.ar;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class f {
    private String aAJ;
    private int aAv;
    private String mFile;
    private String mId;
    private String mName;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mId = jSONObject.optString("id");
            this.mName = jSONObject.optString("name");
            this.mFile = jSONObject.optString("file");
            this.aAJ = jSONObject.optString("bgurl");
            this.aAv = jSONObject.optInt("effect");
        }
    }

    public String getName() {
        return this.mName;
    }

    public String Be() {
        return this.mFile;
    }

    public String Bd() {
        return this.aAJ;
    }

    public int Bh() {
        return this.aAv;
    }
}
